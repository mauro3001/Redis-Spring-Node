const express = require('express'); // Se importa el paquete express
const { request, response } = require('express');
const cors = require('cors');
const redis = require('redis'); // Se importa el paquete redis
require('dotenv').config(); // Lee el archivo de enviroments ".env"

// Connecting to redis
const client = redis.createClient({
  socket: {
    host: 'redis-server',
    port: process.env.PORT_REDIS // 6379
  }
});

client.on( 'error', err  => {
  console.log('Redis client Error', err);
});


client.connect();

const app = express();

// Cors 
app.use( cors() );
// Lectura y parseo del body
app.use( express.json() );

// Establecer visitas iniciales
client.set('students', '');


// * ---- Crear estudiante ----
app.post('/agregar', async ( req, res ) => {
  const { codigo, nombre, email, carrera, nivel  } = req.body;
  await client.set('students', codigo, nombre, email, carrera, nivel);
  res.send('Estudiante registrado');
});

// * ---- Obtener estudiante ----
app.get('/listar', async ( req, res ) => {
  client.get('students', (err, students) => {
    res.send('Students', students);
  });
});


app.listen( process.env.PORT, () => {
    console.log(`aplicacion corriendo en el puerto... ${process.env.PORT}`);
});