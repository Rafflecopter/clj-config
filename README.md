# clj-config

A Clojure library designed to help you read configs from `json` files which can include environment variables.

```
[com.rafflecopter/config "0.1.1"]
```

## Usage

- Add `json` files to your resources path.
- Use the syntax `{env://ENV_VAR_NAME}` in values to be replaced by environment variables.
- You can use the `lein-environ` plugin to set environment variables in your `project.clj`.
- Call `(config.core/config "file1.json" "folder/file2.json")` to setup config.
- Call `(config.core/config)` later to get the config again.

## License

MIT. See `LICENSE` file.
