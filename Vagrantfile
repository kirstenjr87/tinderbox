# -*- mode: ruby -*-
# vi: set ft=ruby :

# Base system bootstrap script
$bootstrap_script = <<__BOOTSTRAP__

echo "----------Provisioning defaults----------"
sudo apt-get update -y
sudo apt-get upgrade -y
sudo apt-get install -y build-essential curl git
echo "----------Finished provisioning defaults----------"

echo "----------Downloading TinderBox----------"
git clone https://github.com/crockpotveggies/tinderbox.git
echo "----------Finished downloading TinderBox----------"

__BOOTSTRAP__


Vagrant.configure(2) do |config|
  #config.vm.box = "vivid64"
  config.vm.box = "trusty64"

  # The url from where the 'config.vm.box' box will be fetched if it
  # doesn't already exist on the user's system.
  #config.vm.box_url = "https://cloud-images.ubuntu.com/vagrant/vivid/current/vivid-server-cloudimg-amd64-vagrant-disk1.box"
  config.vm.box_url = "https://cloud-images.ubuntu.com/vagrant/trusty/current/trusty-server-cloudimg-amd64-vagrant-disk1.box"
  config.vm.network :forwarded_port, host: 9000, guest: 9000
  config.ssh.forward_agent = true

  config.vm.provider :virtualbox do |vbox|
    vbox.customize ["modifyvm", :id, "--memory", "4096"]
    vbox.customize ["modifyvm", :id, "--cpus", "2"]
  end

  config.vm.provision "shell", inline: $bootstrap_script

  config.vm.provision "docker" do |d|
    d.build_image "/home/vagrant/tinderbox/", args: "-t tinderbox:latest" #docker build -t tinderbox tinderbox/
    d.run "tinderbox", args: "-p 0.0.0.0:9000:9000" #docker run -p 0.0.0.0:9000:9000 tinderbox:latest
  end
end
