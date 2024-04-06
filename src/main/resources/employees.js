import React, { useState } from 'react';

function EmployeeManagement() {
    // Estado para controlar qué pestaña está abierta
    const [currentTab, setCurrentTab] = useState('lista');

    // Función para cambiar de pestaña
    const openTab = (tabName) => {
        setCurrentTab(tabName);
    };

    return (
        <div>
            <h1>Gestión de Empleados</h1>

            <div className="tabs">
                <button className="button" onClick={() => openTab('lista')}>Ver Empleados</button>
                <button className="button" onClick={() => openTab('crear')}>Agregar Empleado</button>
                <button className="button" onClick={() => openTab('actualizarna')}>Actualizar Datos</button>
                <button className="button" onClick={() => openTab('eliminar')}>Eliminar Empleado</button>
            </div>

            <div id="lista" className={currentTab === 'lista' ? 'tab' : 'hidden-tab'}>
                {/* Contenido de la pestaña de Ver Empleados */}
            </div>

            <div id="crear" className={currentTab === 'crear' ? 'tab' : 'hidden-tab'}>
                {/* Contenido de la pestaña de Agregar Empleado */}
            </div>

            <div id="actualizarna" className={currentTab === 'actualizarna' ? 'tab' : 'hidden-tab'}>
                {/* Contenido de la pestaña de Actualizar Datos */}
            </div>

            <div id="eliminar" className={currentTab === 'eliminar' ? 'tab' : 'hidden-tab'}>
                {/* Contenido de la pestaña de Eliminar Empleado */}
            </div>
        </div>
    );
}

export default EmployeeManagement;
