


# 1. Remove old MongoDB
sudo apt purge -y mongodb-org* && sudo rm -rf /var/lib/mongodb /var/log/mongodb

# 2. Import key & add repo
curl -fsSL https://pgp.mongodb.com/server-7.0.asc | \
  sudo gpg -o /usr/share/keyrings/mongodb-server-7.0.gpg --dearmor

echo "deb [ arch=amd64,arm64 signed-by=/usr/share/keyrings/mongodb-server-7.0.gpg ] \
https://repo.mongodb.org/apt/ubuntu jammy/mongodb-org/7.0 multiverse" | \
sudo tee /etc/apt/sources.list.d/mongodb-org-7.0.list

# 3. Install MongoDB
sudo apt update && sudo apt install -y mongodb-org

# 4. Start & enable service
sudo systemctl enable --now mongod

# 5. Check status
sudo systemctl status mongod

# 6. Test connection
mongosh --eval "db.runCommand({ ping: 1 })"

