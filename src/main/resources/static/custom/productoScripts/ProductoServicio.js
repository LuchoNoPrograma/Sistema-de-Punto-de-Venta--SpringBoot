class ProductoServicio{
    constructor(){
        this.URL = "/producto/api";
    }

    async listarProductos() {
        const promise = await fetch(this.URL+"/v1/productos",{
            method: "GET", headers: {"Content-Type": "application/json; charset=utf-8"}})
            .catch(error => {
                console.log(error);
            })


        const response = await promise.text();
        return response === "" ? undefined : JSON.parse(response);
    }
}