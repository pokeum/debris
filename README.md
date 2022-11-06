# Debris

Debris is `light-weight` Kotlin dependency injection library.    
Simplified `Koin`

* [Koin (Git)](https://github.com/InsertKoinIO/koin)
* [Koin (Official-Site)](https://insert-koin.io/)

```
Copyright 2017 Arnaud GIULIANI, Laurent BARESSE

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

**Strongly recommend to use Koin instead of Debris**

> **Note**
> * Debris does not support Dynamic Modules. (e.g. loadModules, unloadModules)
> * Debris does not support Context Isolation. (**Support `Global Context` Only**)
> * Debris does not support Scope.

## Table of content

- [Structure](#structure)
- [Domain-specific language](#dsl)
- [Getting started](#getting-started)
- [Examples](#examples)
- [Thanks](#thanks)

## <a id="structure"> Structure

<img src="./docs/drawio/debris-structure.svg"  width="1200">

> **Note**<br/>
> **`DebrisContext` is Global Context**

### How User Interface Works?

<img src="./docs/drawio/debris-user-interface.svg"  width="1200">

## <a id="dsl"> Domain-specific language

<img src="./docs/drawio/debris-dsl.svg"  width="1200">

```kotlin
startDebris {               // this: DebrisApplication
    module {                // this: Module
        single {            // this: Debris
            DerivedClass() as BaseClass
        }
    }
    ...
}
```

## <a id="getting-started"> Getting started

## <a id="examples"> Examples

## <a id="thanks"> Thanks
* [Koin](https://github.com/InsertKoinIO/koin)
* [@Sangryel](https://github.com/Sangryel)'s Debris