# Go-Back-N ARQ Protocol Simulator in Java

This project simulates the **Go-Back-N Automatic Repeat reQuest (ARQ)** protocol, demonstrating reliable data transfer with packet loss and retransmission using Java.

## 🔧 Features
- Sliding window transmission
- Simulated packet loss (20% ACK loss)
- Timeout handling and retransmission
- Simple console-based logging

## 🚀 How to Run

```bash
javac src/GoBackNARQ.java
java -cp src GoBackNARQ
```

## 🔢 Configuration
Change TOTAL_FRAMES and WINDOW_SIZE in GoBackNARQ.java

Modify ACK loss probability using rand.nextInt(10) < 2 logic

## 📌 Credits
Madhan K - 2022504531

Yuvaraj V - 2022504554

Sujith Kumar K - 2022504060
Department of Electronics Engineering, MIT Campus, Anna University

