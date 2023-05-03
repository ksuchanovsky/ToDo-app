Tools setup
---------

The following tooling is required to be installed for the purposes of the tutorial locally:

* git
* JDK >= 11
* node
* aws cli
* docker and docker-compose, or alternatively if you're not willing to pay the license costs: podman and podman-compose

Recommended software:

* Editor, e.g.: [Visual Studio Code](https://code.visualstudio.com/)
* Java IDE, e.g.: [Eclipse IDE](https://www.eclipse.org/) or [Intellij Idea Community Edition](https://www.jetbrains.com/idea/)
* Postgres DB UI, e.g.: [DBeaver Community Edition](https://dbeaver.io/)
* DynamoDB UI, e.g.: [NoSQL Workbench for DynamoDB](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/workbench.html)

Windows installation instructions
---
1. Install Amazon Corretto JDK 11 [Windows Installer](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html)
2. Install [Node.js](https://nodejs.org/dist/v18.12.1/node-v18.12.1-x64.msi)
3. Install [AWS CLI](https://awscli.amazonaws.com/AWSCLIV2.msi)
4. Install [Maven 3.6](https://archive.apache.org/dist/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip) (https://maven.apache.org/install.html)
5. Install Linux Windows Subsystem - [WSL](https://techcommunity.microsoft.com/t5/windows-11/how-to-install-the-linux-windows-subsystem-in-windows-11/m-p/2701207)
6. Install Ubuntu distribution to WSL
7. Install [Podman](https://podman.io/getting-started/installation#ubuntu) to Ubuntu
8. Install [podman-compose](https://devcoops.com/install-podman-compose-on-ubuntu-22.04/) to Ubuntu

Note: It is possible to use Docker instead of Podman

How to setup WSL 2 environment with Ubuntu 20.04
---
Open windows command line and enter following commands:

         wsl --instal
         wsl --install -d ubuntu-20.04
         wsl --set-version Ubuntu-20.04 2

How to fix possible issue with DNS
---
It might happen that Ubuntu machine is unable to resolve hosts (ie. google.com)
We can fix it by adding a DNS server to /etc/resolv.conf file.

1. Open WSL command line with Ubuntu.
       
        wsl -d ubuntu-20.04
 
2. Edit the following file.
       
        sudo nano /etc/resolv.conf

3. Add a new line with DNS server IP address.
       
        nameserver 8.8.8.8 

4. Press CTRL+X and Y to save the change.

How to install podman and podman-compose in Ubuntu
---
Open WSL command line with Ubuntu.

        wsl -d ubuntu-20.04

1. Add a repository with podman package and add PGP key:

        echo "deb https://download.opensuse.org/repositories/devel:/kubic:/libcontainers:/stable/xUbuntu_20.04/ /" |
        sudo tee /etc/apt/sources.list.d/devel:kubic:libcontainers:stable.list
        curl -L "https://download.opensuse.org/repositories/devel:/kubic:\/libcontainers:/stable/xUbuntu_20.04/Release.key" | sudo apt-key add -

2. Install podman package:

        sudo apt-get update
        sudo apt-get install -y podman

3. Install python3 and python3-pip in order to install podman-compose.

        sudo apt-get install -y python3 python3-pip

4. Install podman-compose using python pip

        sudo pip install podman-compose

5. Check if podman is able to run a hello-world container.:

        podman run docker.io/library/hello-world

How to add podman registries to pull images
---
It might happen that podman is not able to pull any image because of no registry to be set.
Follow these steps to add docker.io and quay.io registries.

1. Edit following file

        sudo nano /etc/containers/registries.conf

2. Uncomment  (if line already exists but is commented out) or add a new line

        unqualified-search-registries = ["docker.io", "quay.io"]

3. Press CTRL+X and Y to save the changes

MacOS installation instructions
---

Required tooling:

1. [Homebrew](https://brew.sh/) is the package manager simplifying installation of the required software on MacOS. To install it (as per [official instructions](https://brew.sh/)) run:

        /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

1. Install git via [Homebrew formula](https://formulae.brew.sh/formula/git):

        brew install git

1. Install Amazon Corretto JDK 11 via Homebrew:

        brew tap homebrew/cask-versions
        brew install --cask corretto11

1. Install node via [Homebrew formula](https://formulae.brew.sh/formula/node):

        brew install node

1. Install aws cli via [Homebrew formula](https://formulae.brew.sh/formula/awscli):

        brew install awscli

1. Install Podman via [Homebrew formula](https://formulae.brew.sh/formula/podman):

        brew install podman

1. Install aws cli via [Homebrew formula](https://formulae.brew.sh/formula/podman-compose):

        brew install podman-compose

1. Install Maven via [Homebrew formula](https://formulae.brew.sh/formula/maven):

        brew install maven

Recommended tooling:

1. Install DBeaver Community Edition via [Homebrew formula](https://formulae.brew.sh/cask/visual-studio-code):

        brew install --cask visual-studio-code

1. Install Intellij Idea Community Edition via [Homebrew formula](https://formulae.brew.sh/cask/intellij-idea-ce):

        brew install --cask intellij-idea-ce

1. Install DBeaver Community Edition via [Homebrew formula](https://formulae.brew.sh/cask/dbeaver-community):

        brew install --cask dbeaver-community

1. Install NoSQL Workbench for DynamoDB via [Homebrew formula](https://formulae.brew.sh/cask/nosql-workbench):

        brew install --cask nosql-workbench

