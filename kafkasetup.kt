

Perfect! Let’s do a **complete, clean, final setup** for Kafka 4.x on Ubuntu 22.04 (AWS EC2) with **one command/script to run producer and consumer in parallel**. This will be fully working and ready to test.

---

## **FINAL CLEAN SETUP STEPS**

### **Step 1: Install Java (if not already)**

```bash
sudo apt update
sudo apt install -y openjdk-17-jdk tmux wget
java -version
```

---

### **Step 2: Download and install Kafka 4.x**

```bash
cd /opt
sudo wget https://downloads.apache.org/kafka/4.1.0/kafka_2.13-4.1.0.tgz
sudo tar -xvzf kafka_2.13-4.1.0.tgz
sudo mv kafka_2.13-4.1.0 kafka
sudo chown -R $USER:$USER /opt/kafka
```

---

### **Step 3: Add Kafka to PATH**

```bash
echo 'export PATH=$PATH:/opt/kafka/bin' >> ~/.bashrc
source ~/.bashrc
```

---

### **Step 4: Create KRaft config**

```bash
mkdir -p /opt/kafka/config/kraft
mkdir -p /opt/kafka/kraft-logs
nano /opt/kafka/config/kraft/server.properties
```

Paste the following:

```properties
process.roles=broker,controller
node.id=1
controller.quorum.voters=1@localhost:9093
log.dirs=/opt/kafka/kraft-logs
controller.listener.names=CONTROLLER
listeners=PLAINTEXT://:9092,CONTROLLER://:9093
auto.create.topics.enable=true
```

Save and exit (`Ctrl+X`, `Y`, Enter).

---

### **Step 5: Format Kafka storage**

```bash
kafka-storage.sh format -t $(uuidgen) -c /opt/kafka/config/kraft/server.properties
```

---

### **Step 6: Start Kafka broker**

```bash
kafka-server-start.sh -daemon /opt/kafka/config/kraft/server.properties
```

---

### **Step 7: Create the “run producer & consumer” script**

```bash
nano run-kafka.sh
```

Paste:

```bash
#!/bin/bash
export PATH=$PATH:/opt/kafka/bin

# Start a tmux session for producer & consumer
tmux new-session -d -s kafka-demo

# Pane 0: Consumer
tmux send-keys -t kafka-demo "kafka-topics.sh --create --topic test-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1" C-m
tmux send-keys -t kafka-demo "kafka-console-consumer.sh --topic test-topic --from-beginning --bootstrap-server localhost:9092" C-m

# Split pane horizontally for producer
tmux split-window -h -t kafka-demo
tmux send-keys -t kafka-demo "kafka-console-producer.sh --topic test-topic --bootstrap-server localhost:9092" C-m

# Attach session
tmux attach -t kafka-demo
```

Save and exit.

---

### **Step 8: Make script executable and run**

```bash
chmod +x run-kafka.sh
./run-kafka.sh
```

---

### ✅ **Result**

* **Left pane**: Kafka consumer running, showing messages.
* **Right pane**: Kafka producer running; type messages here.
* Messages appear instantly in the consumer.
* No Zookeeper needed.
* Everything runs in **one command**.

---

I can also give a **super-short one-liner** to do **all of this without creating any script file**, so you just copy-paste in your terminal and start Kafka with producer/consumer immediately.

Do you want me to do that?

