wget https://github.com/jerson/pgrok/releases/download/v3.2.8/pgrok_3.2.8_linux_amd64.deb &&
dpkg -i pgrok_3.2.8_linux_amd64.deb &&
rm pgrok_3.2.8_linux_amd64.deb &&
read -p "Enter HTTP Port: " port
pgrok -serveraddr dns.virtnet.cloud:4443 $port