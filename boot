cat <<EOF >>/opt/virtnet/launch.sh
#!/bin/sh
dhclient -4 &
echo 'Acquire::ForceIPv4 'true';' > /etc/apt/apt.conf.d/99force-ipv4 &
echo 'precedence ::ffff:0:0/96 100' > /etc/gai.conf &
echo 'Acquire::http::Proxy \"http://172.16.0.135:9696\";' > /etc/apt/apt.conf.d/00aptproxy &
EOF
chmod +x /opt/virtnet/launch.sh
cat <<EOF >> /etc/systemd/system/virtnet.service
[Unit]
Description=QOL Improvements
After=network.target
After=systemd-user-sessions.service
After=network-online.target

[Service]
ExecStart=/opt/virtnet/launch.sh

[Install]
WantedBy=multi-user.target
EOF
sudo systemctl start virtnet.service
sudo systemctl enable virtnet.service
