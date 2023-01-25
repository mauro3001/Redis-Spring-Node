const express = require('express'); 
const { request, response } = require('express');
const cors = require('cors');
const redis = require('redis'); 
require('dotenv').config(); 

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


app.use( cors() );

app.use( express.json() );


client.set('estudiantes', '');


app.post('/agregar', async ( req, res ) => {
  const { codigo, nombre, email, carrera, nivel  } = req.body;
  await client.set('estudiantes', codigo + nombre + email + carrera + nivel);
  res.send('El estudiante ha sido registrado');
});


app.get('/listar', async ( req, res ) => {
  client.get('estudiantes', (err, estudiantes) => {
    res.send('estudiantes', estudiantes);
  });
});


app.listen( process.env.PORT, () => {
    console.log(`aplicacion corriendo en el puerto... ${process.env.PORT}`);
});