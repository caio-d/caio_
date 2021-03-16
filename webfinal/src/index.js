import './index.css'
import React from 'react'
import ReactDOM from 'react-dom'
import Formulario from './components/Formulario'
import Links from './components/Links'

ReactDOM.render(
    <div>
        <Formulario></Formulario>
        <Links></Links>
    </div>,
    document.getElementById('root')
)