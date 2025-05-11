async function listarLivros() {
    try {
      fetch("http://localhost:8080/livros")
        .then(response => response.json())
        .then(livros => {
          const container = document.getElementById("livrosContainer");
          container.innerHTML = "";

          livros.forEach(livro => {
            const card = document.createElement("div");
            card.className = "card";

            card.innerHTML = `
              <img src="${livro.foto}" alt="${livro.nome}">
              <div class="card-content">
                <h2>${livro.nome} pág.:${livro.numero_paginas}</h2>
                <p>Autor: ${livro.autor} | Editora: ${livro.editora}
                <div class="actions">
                  <form>
                    <button type="submit" class="btn-delete" id="arquivo-${livro.id_livro}" onclick="deletarLivro(${livro.id_livro})">Deletar</button>
                  </form>
                </div>
              </div>
            `;

            container.appendChild(card);
          });
        })
        .catch(error => console.error("Erro ao carregar itens:", error));
    } catch (err) {
      console.error("Erro ao carregar livros:", err);
    }
  }

document.addEventListener("DOMContentLoaded", listarLivros);

function salvarLivro(){
  document.getElementById("formLivro").addEventListener("submit", function (e) {
    e.preventDefault();

    const livro = {
      nome: document.getElementById("titulo").value,
      numero_paginas: document.getElementById("paginas").value,
      edicao: document.getElementById("edicao").value,
      foto: document.getElementById("imagemUrl").value,
      autor: document.getElementById("autor").value,
      editora: document.getElementById("editora").value,
      categoria: document.getElementById("categoria").value
    };

    fetch("http://localhost:8080/livros", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(livro)
    })
    .then(response => {
      if (response.ok) {
        document.getElementById("formLivro").reset();
      } else {
        alert("Erro ao salvar!");
      }
    })
    .catch(error => {
      alert("Erro na requisição:" + error);
    });
  });
}

function deletarLivro(id) {
  if (confirm("Tem certeza que deseja deletar este arquivo?")) {
    fetch(`http://localhost:8080/livros/${id}`, {
      method: 'DELETE'
    })
    .then(response => {
      if (response.ok) {
        alert("Arquivo deletado com sucesso.");
        // Opcional: remover visualmente o item da página
        document.getElementById(`arquivo-${id}`).remove();
      } else {
        alert("Erro ao deletar o arquivo.");
      }
    })
    .catch(error => {
      console.error("Erro ao fazer requisição DELETE:", error);
      alert("Erro de conexão com o servidor.");
    });
  }
}
