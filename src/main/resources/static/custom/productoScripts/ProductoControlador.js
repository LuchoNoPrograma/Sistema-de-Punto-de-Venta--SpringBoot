const app = document.querySelector("#app")
const productoServicio = new ProductoServicio()

//Para reemplazar un nodo por otro, utilizar document.querySelector("#seccionNombre")
const tabla = `
    <section class="container-fluid px-5" id="seccionTabla">
        <div class="card my-3">
            <div class="card-header d-flex flex-row mb-2 gap-4">
                <a class="btn btn-success" onclick="desplegarFormulario()">
                    Agregar
                    <i class="fa-solid fa-user-plus"></i>
                </a>
            </div>
            <div class="card-body d-flex flex-column">        
                <table class="table table-striped table-bordered text-center">
                    <thead class="table-dark">
                        <tr>
                            <th>#</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Editar</th>
                            <th>Eliminar</th>
                        </tr>
                    </thead>
                    <tbody id="tableBody">
                    </tbody>
                    <tfoot class="table-dark">
                        <th>#</th>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Editar</th>
                        <th>Eliminar</th>
                    </tfoot>
                </table>
            </div>
            <div class="card-footer d-flex flex-row-reverse gap-4">  
            </div>
        </div>
    </section>`

const formulario = `
    <section class="container-fluid px-5 ">
        <div class="card my-3">
            <div class="card-header">
                <h3>Registrar producto <i class="fa-solid fa-file-circle-plus mx-2"></i></h3>
            </div>
            <div class="card-body">
                <form action="" method="get">
                    <div class="row">
                        <div class="col-4">
                            <label for="producto">Nombres</label>
                            <input type="text" name="producto" id="producto" class="form-control">
                        </div>
                        <div class="col-4">
                            <label for="codigo">Codigo</label>
                            <input type="text" name="codigo" id="codigo" class="form-control">
                        </div>
                        <div class="col-2">
                            <label for="precio">Precio</label>
                            <input type="text" name="precio" id="precio" class="form-control" placeholder="Bs.">
                        </div>
                        <div class="col-2">
                            <label for="fechaIngreso">Fecha Ingreso</label>
                            <input type="date" name="fechaIngreso" id="fechaIngreso" class="form-control">
                        </div>
                    </div>
                </form>
            </div>
            <div class="card-footer">
                <div class="d-flex flex-row-reverse">
                    <button class="btn btn-success" type="submit" onclick="agregarProducto()">Agregar
                        <i class="fa-solid fa-cart-plus"></i>
                    </button>
                </div>
            </div>
        </div>
    </section>`

//Seccion por defecto
app.innerHTML = tabla
const tableBody = document.querySelector("#tableBody");

async function generarFila(){
    const data = await productoServicio.listarProductos();
    
    data.forEach(e => {
        let fila = tableBody.insertRow(-1);
        fila.insertCell(0).innerHTML = e.idItem
        fila.insertCell(1).innerHTML = e.nombre
        fila.insertCell(2).innerHTML = e.precio
        fila.insertCell(3).innerHTML = `
        <button class="btn btn-primary" type="submit">
            <i class="fa-solid fa-pencil"></i>
        </button>`;

        fila.insertCell(4).innerHTML = `
        <button class="btn btn-danger" type="submit">
            <i class="fa-solid fa-trash"></i>
        </button>`;  
    });
}

generarFila()

const desplegarFormulario = () => {
    app.removeChild(document.querySelector("#seccionTabla"));
    app.innerHTML = formulario;
}

let o = {
    estrin: "xd"
}


async function postData(url, data) {
    const response = await fetch(url, {
      method: 'POST', // *GET, POST, PUT, DELETE, etc.
      mode: 'cors', // no-cors, *cors, same-origin
      cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
      credentials: 'same-origin', // include, *same-origin, omit
      headers: {
        'Content-Type': 'application/json',
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      redirect: 'follow', // manual, *follow, error
      body: JSON.stringify(data) // body data type must match "Content-Type" header
    });
    console.log(JSON.stringify(data))
    return response.json(); // parses JSON response into native JavaScript objects
}

const agregarProducto = () => {
    postData("/producto/prueba", o)
        .then(data =>{
            console.log(data)
        })
} 