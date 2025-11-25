# ¡Haz que vaya!

## Cálculo de Acceso a Agua Potable por Comunidad

Este proyecto forma parte de una actividad académica donde se nos proporcionó un código PHP encargado de calcular el acceso a agua potable en diferentes comunidades según:

- Población
- Número de pozos
- Existencia o no de acueducto

Nuestro objetivo como estudiantes fue analizar el código original, detectar errores y corregirlos para obtener un cálculo válido y comprensible.

### LogiLógica del Cálculo

1. Determinar la cobertura base

    Depende de si la comunidad tiene acueducto
    - Si tiene acueducto → acceso base = 0.90 (90%)
    - Si no tiene acueducto → acceso base = 0.40 (40%)

    Esto representa el nivel mínimo de acceso.

2. Calcular el bono por pozos

    Se calcula en función de cuántos pozos hay respecto a la población:

        bono_pozos = pozos / población * 1000

    Significado:

    **Tener 1 pozo por cada 1000 habitantes aumenta un 10% (0.10) el acceso.**

    Para evitar valores irreales, se limita:

        if bono_pozos > 0.30 entonces bono_pozos = 0.30

    Es decir, **máximo 30% de bono.**

3. Calcular el acceso total por comunidad

    Se suman:

        acceso_total = acceso_base + bono_pozos


    Y se limita a un máximo del 100%:

        if acceso_total > 1 entonces acceso_total = 1

4. Calcular el porcentaje global

    Se calcula la población ponderada:
    
        poblacion_con_acceso += población_de_la_comunidad * acceso_total
    
    
    Y luego se obtiene el porcentaje final sobre la población total:
    
        porcentaje_final = (poblacion_con_acceso / poblacion_total) * 100
    
    Este es el resultado final que muestra el programa.