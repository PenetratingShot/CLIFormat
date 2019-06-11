# CLIFormat

A simple java library to easily add command line arguments with function builders.

## Development

- [x] Format Class
    - [x] Variables
    - [x] Getters
    - [x] Setters
- [x] Function Builder
    - [x] Generics
- [ ] Flags
    - [x] "--" flags
    - [ ] "-" flags out of "--" flags
    - [ ] priority flags (0, 1, 2)
    
## Usage

1. Import the jar file from the releases tab

2. `import com.shreyaslad.CLIFormat`

3. 

```java
Format format = GenericBuilder.of(Format::new)
                .with(Format::setFlagString, "--create").with(Format::setTypeFlag, 0).build();
```

You can access the flagString, which in this case would be `--create` by doing `format.getFlagString`.

You can access the priority setting by doing `format.getTypeFlag`.

##### Update 0.2.0

- Added ability to parse data in between two "solid" flags (flags that will be in that specific order 100% of the time).

Two new functions: 

1. `CLIRegex.afterFlag(<string>, <flagString>)`
2. `CLIRegex.betweenFlags(<string>, <firstFlag>, <secondFlag>)`

#### Priority Settings

Basically priority settings tell whether the flag can be ignored or not. This is a WIP feature and might be removed because I', not smart enough :/

| Flag | Priority|
|:-----:|:--------:|
| 0 | Not Required |
| 1 | Required|