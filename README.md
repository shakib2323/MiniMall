# 🛍️ MiniMall — Java Console Shopping App

A simple console-based shopping application built with core Java. Users can browse products, add items to a cart, and get a final 
receipt with an automatic discount applied.

---

## 📋 Features

- Browse a product catalog (Trouser, T-Shirt, Shoes)
- Place up to **100000 orders** per session
- Enter quantity per item
- Confirm or cancel each order before it's added to the cart
- **10% discount** applied automatically when total exceeds Rs.500
- Clean formatted receipt printed at the end

---

## 🗂️ Project Structure

```
src/
└── com/
    └── nt/
        └── p1/
            └── MiniMall.java
```

### Classes inside `MiniMall.java`

| Class / Component | Role |
|---|---|
| `MiniMall` | Main class — runs the shopping session |
| `Product` | Holds product name and price |
| `OrderItem` | Holds selected product, quantity, and subtotal |
| `PRODUCTS[]` | Static catalog of available items |
| `cart` | `List<OrderItem>` that tracks everything added |

---

## 🚀 How to Run

### Prerequisites
- Java 8 or above installed
- Any IDE (Eclipse, IntelliJ IDEA, VS Code) or just the terminal

### Compile & Run from Terminal

```bash
# Step 1 — Create the package folders
mkdir -p src/com/nt/p1

# Step 2 — Place MiniMall.java inside src/com/nt/p1/

# Step 3 — Compile
javac src/com/nt/p1/MiniMall.java -d out/

# Step 4 — Run
java -cp out com.nt.p1.MiniMall
```

### Run from Eclipse IDE/IntelliJ IDEA
1. Open the project folder
2. Mark `src` as Sources Root
3. Right-click `MiniMall.java` → Run

---

## 🛒 How It Works

```
App starts
    │
    ▼
Show product catalog
    │
    ▼
User picks a product (1, 2, or 3)
    │
    ▼
User types "yes" to confirm
    │
    ▼
User enters quantity
    │
    ▼
Item added to cart
    │
    ▼
Continue shopping? (yes / no)
    │
    ├── yes → next order (up to 100000 total)
    │
    └── no → print receipt and exit
```

---

## 🧾 Sample Output

```
═══════════════════════════════════════════
              MINI MALL STORE               
═══════════════════════════════════════════
Welcome to Mini Mall! You can place up to 5 orders per session.

─────────────────────────────────────────
  Order #1
─────────────────────────────────────────

  Available Products:
  [1] Trouser               Rs.1999
  [2] T-Shirt (Nike)        Rs.599
  [3] Shoes (Puma)          Rs.4999

Enter product number: 2
You selected: T-Shirt (Nike)   Price: Rs.599
Confirm selection? (yes/no): yes
Enter quantity: 3
Added to cart → T-Shirt (Nike) x3 = Rs.1797

Continue shopping? (yes/no): no

═══════════════════════════════════════════
              MINI MALL — RECEIPT           
═══════════════════════════════════════════
Product                   Qty     Amount
───────────────────────────────────────────
T-Shirt (Nike)              3    Rs.1797
───────────────────────────────────────────
Subtotal:                       Rs.1797
Discount (10%):                 -Rs.179
───────────────────────────────────────────
Total Payable:                  Rs.1618
═══════════════════════════════════════════
         Thank you for shopping with us!    
═══════════════════════════════════════════
```

---

## 💡 Key Design Decisions

**Why Product classes (`Product`, `OrderItem`)?**  
Instead of using separate variables for price, name, quantity per item, the product classes keep related data together. This is the standard Java way to model
entities even in small projects.

**Why `List<OrderItem>` instead of static variables?**  
The `List` means the cart grows dynamically and the billing logic stays in one place with no duplication.

**Why a separate `printReceipt()` method?**  
All billing and discount logic lives in one method. Change the discount rate or threshold in one place and it reflects everywhere.

---

## 📦 Tech Stack

| | |
|---|---|
| Language | Java 8+ |
| Input | `java.util.Scanner` |
| Collections | `java.util.ArrayList` |
| IDE | Any (Eclipse IDE recommended) |
| Build tool | None (plain javac) |

---

## 🔧 Possible Improvements

- Add more products to the catalog
- Load products from a file or database instead of hardcoding
- Add a proper login/user system
- Export the receipt to a `.txt` or `.pdf` file
- Build a GUI version using Java Swing or JavaFX

---

## 👤 Author

**Shakib Ali**  
Java Full Stack Developer — Backend & Spring Boot  
Built as a core Java practice project.

---

## 📄 License

This project is open for learning and personal use.
