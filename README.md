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

## Table of content

- [Domain-specific language](#dsl)
- [Thanks](#thanks)

## <a id="dsl"> Domain-specific language

<img src="./docs/drawio/debris-dsl.svg"  width="1000">

```kotlin
startDebris {               // this: DebrisApplication
    module {                // this: Module
        single {            // this: Debris
            HelloSayer() 
        }
    }
    ...
}
```

## <a id="thanks"> Thanks
* [Koin](https://github.com/InsertKoinIO/koin)
* [@Sangryel](https://github.com/Sangryel)'s Debris