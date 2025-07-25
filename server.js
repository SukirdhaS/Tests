const express = require("express");
const app = express();
const PORT = process.env.PORT || 10000;

app.use(express.json()); // Parses incoming JSON

// Dummy in-memory data store
let shopData = [
  { id: 1, product: "Pen", price: "10" },
  { id: 2, product: "Notebook", price: "20" }
];

// GET all products
app.get("/Shop", (req, res) => {
  res.json(shopData);
});

// POST a new product
app.post("/Shop", (req, res) => {
  const newProduct = req.body;
  shopData.push(newProduct);
  res.status(201).json({ message: "Product added", data: newProduct });
});

// PUT (replace) product by ID
app.put("/Shop/:id", (req, res) => {
  const { id } = req.params;
  const index = shopData.findIndex(p => p.id == id);
  if (index !== -1) {
    shopData[index] = req.body;
    res.json({ message: "Product replaced", data: shopData[index] });
  } else {
    res.status(404).json({ message: "Product not found" });
  }
});

// PATCH (update) product by ID
app.patch("/Shop/:id", (req, res) => {
  const { id } = req.params;
  const index = shopData.findIndex(p => p.id == id);
  if (index !== -1) {
    shopData[index] = { ...shopData[index], ...req.body };
    res.json({ message: "Product updated", data: shopData[index] });
  } else {
    res.status(404).json({ message: "Product not found" });
  }
});

// DELETE product by ID
app.delete("/Shop/:id", (req, res) => {
  const { id } = req.params;
  const index = shopData.findIndex(p => p.id == id);
  if (index !== -1) {
    const removed = shopData.splice(index, 1);
    res.json({ message: "Product deleted", data: removed[0] });
  } else {
    res.status(404).json({ message: "Product not found" });
  }
});

// OPTIONS
app.options("/Shop", (req, res) => {
  res.set("Allow", "GET, POST, PUT, PATCH, DELETE, OPTIONS");
  res.send();
});

// Start server
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
