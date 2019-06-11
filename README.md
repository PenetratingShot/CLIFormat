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

#### Priority Settings

Basically priority settings tell whether the flag can be ignored or not. This is a WIP feature and might be removed because I', not smart enough :/

| Flag | Priority|
|:-----:|:--------:|
| 0 | Not Required |
| 1 | Required|