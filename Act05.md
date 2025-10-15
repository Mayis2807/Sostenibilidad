# Act05 - Análisis de Viviendas por Intensidad de Uso

Programa en Java que analiza datos de consumo eléctrico de viviendas y muestra los 3 municipios con la mediana de consumo anual más alta.

## Descripción

Este programa procesa un archivo CSV que contiene datos sobre viviendas por intensidad de uso a partir del consumo eléctrico. El objetivo es identificar y mostrar los tres municipios que tienen la mediana de consumo anual más alta, ordenados de forma descendente.

## Funcionalidades

- Lectura y procesamiento de archivos CSV
- Filtrado de datos por tipo de territorio (solo municipios)
- Ordenamiento descendente por valor de mediana
- Visualización de los top 3 municipios con mayor consumo

## Uso

### Compilación

```bash
javac Act05.java
```

## Formato de entrada

El programa espera un archivo CSV con el siguiente formato:

```bash
Año;Tipo territorio;Código territorio;Territorio;Valor;Estado dato
2021;Comunidad de Madrid;;Comunidad de Madrid;2281;Provisional
2021;Municipios;0014;Acebeda (La);-;Provisional
2021;Municipios;0029;Ajalvir;2284;Provisional
```

## Salida esperada

```bash
Territorio: Tielmes
Valor: 3741
Código: 1467

Territorio: Nuevo Bazt?n
Valor: 3663
Código: 1006

Territorio: Torres de la Alameda
Valor: 3607
Código: 1548
```

## Solución implementada

1. **Lectura del archivo**: El programa acepta como argumento la ruta del CSV
2. **Procesamiento línea por línea**: Utiliza `BufferedReader` para lectura eficiente
3. **Validación**: Ignora valores vacíos o no numéricos
4. **Creacion**:  Crea los objetos `Municipio` y los agregamos a una lista (`ArrayList`)
5. **Ordenamiento**: Utiliza `Collections.sort()` con `Comparator` personalizado
6. **Salida**: Muestra los 3 municipios con mayor mediana
