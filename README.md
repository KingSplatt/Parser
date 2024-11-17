
## Explicación del proyecto

Se implementara un parser recursivo - Descendente basado en el pseudocódigo visto en clase, con su respectivo scanner(lexer) para la gramatica aqui descrita

Si el parser o el scanner encuentra errores debera desplegar el error y despues parar la compilación (Tambien puede continuar buscando mas errores)

El proyecto se probará con dos programas con errores y uno sin errores.

### Gramatica

```bash
  P -> D S <eof>
  D -> id (int | string ) ε ; D
  D -> ε
  S -> while E do S
  S -> id = E
  S -> print E
  E -> id + id | id
  id -> letra(letra | digito)*
```

### primer código (error)

```bash
  x1 int ; print t4 +
  Error (se esperaba un id)
```

### segundo código (error)

```bash
  apuntes83 int ; persona string ; while persona do print print
  Error (se esperaba una expresion o un id)
```

### Tercer código (sin error)

```bash
  a83 int ; b32 string ; while a3 do print b8
```