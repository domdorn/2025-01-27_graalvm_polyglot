#!/bin/bash

# Navigate to the Rust source directory
cd "$(dirname "$0")"

DIR="$(dirname "$0")"

# Ensure wasm-pack is installed
if ! command -v wasm-pack &> /dev/null
then
    echo "wasm-pack not found. Installing..."
    cargo install wasm-pack
fi

echo "DIR is $DIR"

cd $DIR/src/main/rust/random

# Build the Rust project to WebAssembly
echo "Building WebAssembly..."

#wasm-pack build --target web --out-dir ../../resources/wasm/random

cargo build --target wasm32-unknown-unknown --release
mkdir -p ../../resources/wasm/random
cp target/wasm32-unknown-unknown/release/*.wasm ../../resources/wasm/random/

# Output location of WASM file
echo "WebAssembly build complete. Files are in $DIR/src/main/resources/wasm/random"