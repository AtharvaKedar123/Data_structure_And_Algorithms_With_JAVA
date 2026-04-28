# AVL Tree (Self-Balancing BST)

## 📌 Concept
An AVL Tree is a self-balancing Binary Search Tree where the height difference (balance factor) between left and right subtrees is at most 1.

## 🚀 Why it is used
Prevents skewed trees and ensures fast operations even in worst cases.

## ⏱ Time Complexity
- Search: O(log n)
- Insert: O(log n)
- Delete: O(log n)

## 🧠 Key Idea
After every insertion/deletion, perform rotations to maintain balance:
- LL Rotation
- RR Rotation
- LR Rotation
- RL Rotation

## 💻 Implementation Details
Maintains height of each node and calculates balance factor to decide rotations.

## 📍 Real-World Use Case
- Database indexing
- Memory management systems
