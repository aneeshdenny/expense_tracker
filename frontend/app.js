let editingExpenseId = null;
const BASE_URL = "http://localhost:8080/api/expenses";

//Load expenses when page opens
window.onload = () => {
    loadExpenses();
    loadTotalExpenses();
};

//Add or Edit Expenses
function addExpenses() {
    const expense = {
        title: document.getElementById("title").value,
        amount: parseFloat(document.getElementById("amount").value),
        category: document.getElementById("category").value
    };
    //Edit Expense
    if(editingExpenseId !== null) {
        fetch(BASE_URL + "/" + editingExpenseId, {
            method: "PUT",
            headers:{
                "Content-Type": "application/json"
            },
            body: JSON.stringify(expense)
        })
        .then(response => response.json())
        .then(() => {
            editingExpenseId = null;
            document.getElementById("submitBtn").innerText = "Add Expense";
            clearInputs();
            loadExpenses();
            loadTotalExpenses();
        })
        .catch(error => console.log(error));
    }

    // Add new expense
    else {
        fetch(BASE_URL, {
            method: "POST",
            headers: {
                "Content-Type":"application/json"
            },
            body: JSON.stringify(expense)
        })
        .then(response => response.json())
        .then(data => {
            clearInputs();
            loadExpenses();
            loadTotalExpenses();
        })
        .catch(error => console.log(error));
    }
    
}

//Load All Expenses
function loadExpenses() {
    fetch(BASE_URL)
    .then(response => response.json())
    .then(data => {
        let rows = "";
        data.forEach(expense => {
            rows += `
            <tr>
                <td>${expense.title}</td>
                <td>${expense.amount}</td>
                <td>${expense.category}</td>
                <td>
                    <button onclick="editExpenses(
                    ${expense.id},
                    '${expense.title}',
                    ${expense.amount},
                    '${expense.category}')">
                    Edit
                    </button>
                    <button onclick="deleteExpense(${expense.id})">
                    Delete
                    </button>
                </td>
            </tr>
            `;
        });
        document.getElementById("expenseTable").innerHTML = rows;
    })
    .catch(error => console.log(error));
}

//Load Total expense
function loadTotalExpenses() {
    fetch(BASE_URL + "/total")
    .then(response => response.text())
    .then(total => {
        document.getElementById("totalAmount").innerText = total;
    })
    .catch(error => console.log(error));
}

//Delete the Expense
function deleteExpense(id) {
    fetch(BASE_URL + "/" + id, {
        method: "DELETE"
    })
    .then(() => {
        loadExpenses();
        loadTotalExpenses();
    })
    .catch(error => console.log(error));
}

//Edit Expenses
function editExpenses(id, title, amount, category) {
    editingExpenseId = id;
    document.getElementById("title").value = title;
    document.getElementById("amount").value = amount;
    document.getElementById("category").value = category;
    document.getElementById("submitBtn").innerText = "Update Expense";
}

function clearInputs() {
    document.getElementById("title").value = "";
    document.getElementById("amount").value = "";
    document.getElementById("category").value = "";
}