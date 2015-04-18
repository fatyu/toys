function testSwitch(x) {
    switch (typeof x) {
        case 'number':
            return x.toString(16);
        case 'string':
            return "'" + x + "'";
        case 'boolean':
            return x.toString().toUpperCase();
        default:
            return x.toString();
    }
}