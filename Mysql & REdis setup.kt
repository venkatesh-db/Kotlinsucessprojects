

# mysql 

sudo apt update
sudo apt install mysql-server
sudo mysql_secure_installation
sudo systemctl start mysql
sudo systemctl enable mysql


# redis 


# Update package index
sudo apt update

# Install Redis server
sudo apt install redis-server -y

# Enable and start Redis
sudo systemctl enable redis-server
sudo systemctl start redis-server

# Check status
sudo systemctl status redis-server

# Test Redis (ping should return PONG)
redis-cli ping
