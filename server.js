const express = require('express');
const app = express();
const fs = require('fs');
const PORT = process.env.PORT || 3000;

app.get('/Shop', (req, res) => {
  const data = fs.readFileSync('shop.json', 'utf-8');
  res.json(JSON.parse(data));
});

app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
