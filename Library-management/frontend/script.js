const api = "http://localhost:8080/api"; // Base URL for your Spring Boot backend

function addResource() {
  const data = {
    id: document.getElementById("resId").value,
    title: document.getElementById("resTitle").value,
    type: document.getElementById("resType").value
  };

  fetch(`${api}/resources`, {
    method: "POST",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify(data)
  }).then(res => res.json())
    .then(() => alert("Resource added"));
}

function registerMember() {
  const data = {
    id: document.getElementById("memId").value,
    name: document.getElementById("memName").value
  };

  fetch(`${api}/members`, {
    method: "POST",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify(data)
  }).then(res => res.json())
    .then(() => alert("Member registered"));
}

function listResources() {
  fetch(`${api}/resources`)
    .then(res => res.json())
    .then(data => {
      document.getElementById("resources").textContent = JSON.stringify(data, null, 2);
    });
}
