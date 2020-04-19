<h1 align="center">Bem-vindo ao MipSimulator 👋</h1>
<p>
  <img alt="Versão" src="https://img.shields.io/badge/version-1.0.0-blue.svg?cacheSeconds=2592000" />
  <img src="https://img.shields.io/badge/java-1.8-blue.svg" />
  <a href="https://github.com/PedroLucasOM/MipSimulator#readme" target="_blank">
    <img alt="Documentação" src="https://img.shields.io/badge/documentação-sim-green.svg" />
  </a>
  <a href="https://github.com/kefranabg/readme-md-generator/graphs/commit-activity" target="_blank">
    <img alt="Mantida" src="https://img.shields.io/badge/mantida-sim-green.svg" />
  </a>
  <a href="https://twitter.com/PedroLucasOM" target="_blank">
    <img alt="Twitter: PedroLucasOM" src="https://img.shields.io/twitter/follow/PedroLucasOM.svg?style=social" />
  </a>
</p>

> Aplicação Java para simular estado dos registradores após executar comandos Assembly.

### 🏠 [Página Inicial](https://github.com/PedroLucasOM/MipSimulator)

## Pré-requisitos

- Java JDK = 1.8

## Execução

```sh
java -jar src/com.mipsimulator/MipSimulator.java
```

## Resultado de Execução

#### Entrada

```sh
addi $t0,$t0,10
label: addi $s3,$s3,2
sw $s3,0($s3)
add $s0,$s3,$s0
lw $s7,0($s0)
beq $s3,$t0,final
j label
final:
```

#### Saída

```sh
Registradores:
Registrador [nome=$t0, valor=10, endereco=68fa9f27-8b95-40f4-a8cb-334fa261955f]
Registrador [nome=$s3, valor=10, endereco=458ef6f4-4097-459b-a159-3a562a454640]
Registrador [nome=$s0, valor=30, endereco=81754771-e9b8-4bab-aabb-c16bf4061b69]
Registrador [nome=$s7, valor=0, endereco=89cdfa40-cada-4686-aa0e-7755365ecb62]

Memória:
Endereco [endereco=2, valor=2]
Endereco [endereco=4, valor=4]
Endereco [endereco=6, valor=6]
Endereco [endereco=8, valor=8]
Endereco [endereco=10, valor=10]
```

## Autor

👤 **Pedro Lucas**

* Twitter: [@PedroLucasOM](https://twitter.com/PedroLucasOM)
* Github: [@PedroLucasOM](https://github.com/PedroLucasOM)
* LinkedIn: [@PedroLucasOM](https://linkedin.com/in/PedroLucasOM)

## 🤝 Contribuição

Contribuições, problemas e solicitações de recursos são bem-vindos! <br /> Sinta-se à vontade para verificar a 
[página de problemas](https://github.com/PedroLucasOM/MipSimulator/issues).

## Mostre seu apoio

Dê um ⭐️ se este projeto ajudou você!

## 📝 Licença

Copyright © 2020 [Pedro Lucas](https://github.com/PedroLucasOM).<br />
