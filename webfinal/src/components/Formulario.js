import React from 'react'

function Formulario() {
    return (
        <form>
            <h1>Notícias de tecnologia todos os dias!</h1>
            <label>Seu Email Aqui:</label>
            <br></br>
            <input type="text" name="email" maxLength= "30" size="20"></input>
            <br></br>
            <a href="cadastrou.html"><span>Cadastrar</span></a>
        </form>
    )
}

export default Formulario