/*
 * Copyright (c) 2020 Ronald MacDonald <ronald@rmacd.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

(function(){function r(e,n,t){function o(i,f){if(!n[i]){if(!e[i]){var c="function"==typeof require&&require;if(!f&&c)return c(i,!0);if(u)return u(i,!0);var a=new Error("Cannot find module '"+i+"'");throw a.code="MODULE_NOT_FOUND",a}var p=n[i]={exports:{}};e[i][0].call(p.exports,function(r){var n=e[i][1][r];return o(n||r)},p,p.exports,r,e,n,t)}return n[i].exports}for(var u="function"==typeof require&&require,i=0;i<t.length;i++)o(t[i]);return o}return r})()({1:[function(require,module,exports){
        module.exports = function (it) {
            if (typeof it != 'function') throw TypeError(it + ' is not a function!');
            return it;
        };

    },{}],2:[function(require,module,exports){
// 22.1.3.31 Array.prototype[@@unscopables]
        var UNSCOPABLES = require('./_wks')('unscopables');
        var ArrayProto = Array.prototype;
        if (ArrayProto[UNSCOPABLES] == undefined) require('./_hide')(ArrayProto, UNSCOPABLES, {});
        module.exports = function (key) {
            ArrayProto[UNSCOPABLES][key] = true;
        };

    },{"./_hide":24,"./_wks":75}],3:[function(require,module,exports){
        'use strict';
        var at = require('./_string-at')(true);

        // `AdvanceStringIndex` abstract operation
// https://tc39.github.io/ecma262/#sec-advancestringindex
        module.exports = function (S, index, unicode) {
            return index + (unicode ? at(S, index).length : 1);
        };

    },{"./_string-at":63}],4:[function(require,module,exports){
        var isObject = require('./_is-object');
        module.exports = function (it) {
            if (!isObject(it)) throw TypeError(it + ' is not an object!');
            return it;
        };

    },{"./_is-object":31}],5:[function(require,module,exports){
// false -> Array#indexOf
// true  -> Array#includes
        var toIObject = require('./_to-iobject');
        var toLength = require('./_to-length');
        var toAbsoluteIndex = require('./_to-absolute-index');
        module.exports = function (IS_INCLUDES) {
            return function ($this, el, fromIndex) {
                var O = toIObject($this);
                var length = toLength(O.length);
                var index = toAbsoluteIndex(fromIndex, length);
                var value;
                // Array#includes uses SameValueZero equality algorithm
                // eslint-disable-next-line no-self-compare
                if (IS_INCLUDES && el != el) while (length > index) {
                    value = O[index++];
                    // eslint-disable-next-line no-self-compare
                    if (value != value) return true;
                    // Array#indexOf ignores holes, Array#includes - not
                } else for (;length > index; index++) if (IS_INCLUDES || index in O) {
                    if (O[index] === el) return IS_INCLUDES || index || 0;
                } return !IS_INCLUDES && -1;
            };
        };

    },{"./_to-absolute-index":66,"./_to-iobject":68,"./_to-length":69}],6:[function(require,module,exports){
// getting tag from 19.1.3.6 Object.prototype.toString()
        var cof = require('./_cof');
        var TAG = require('./_wks')('toStringTag');
// ES3 wrong here
        var ARG = cof(function () { return arguments; }()) == 'Arguments';

// fallback for IE11 Script Access Denied error
        var tryGet = function (it, key) {
            try {
                return it[key];
            } catch (e) { /* empty */ }
        };

        module.exports = function (it) {
            var O, T, B;
            return it === undefined ? 'Undefined' : it === null ? 'Null'
                // @@toStringTag case
                : typeof (T = tryGet(O = Object(it), TAG)) == 'string' ? T
                    // builtinTag case
                    : ARG ? cof(O)
                        // ES3 arguments fallback
                        : (B = cof(O)) == 'Object' && typeof O.callee == 'function' ? 'Arguments' : B;
        };

    },{"./_cof":7,"./_wks":75}],7:[function(require,module,exports){
        var toString = {}.toString;

        module.exports = function (it) {
            return toString.call(it).slice(8, -1);
        };

    },{}],8:[function(require,module,exports){
        var core = module.exports = { version: '2.6.11' };
        if (typeof __e == 'number') __e = core; // eslint-disable-line no-undef

    },{}],9:[function(require,module,exports){
        'use strict';
        var $defineProperty = require('./_object-dp');
        var createDesc = require('./_property-desc');

        module.exports = function (object, index, value) {
            if (index in object) $defineProperty.f(object, index, createDesc(0, value));
            else object[index] = value;
        };

    },{"./_object-dp":42,"./_property-desc":53}],10:[function(require,module,exports){
// optional / simple context binding
        var aFunction = require('./_a-function');
        module.exports = function (fn, that, length) {
            aFunction(fn);
            if (that === undefined) return fn;
            switch (length) {
                case 1: return function (a) {
                    return fn.call(that, a);
                };
                case 2: return function (a, b) {
                    return fn.call(that, a, b);
                };
                case 3: return function (a, b, c) {
                    return fn.call(that, a, b, c);
                };
            }
            return function (/* ...args */) {
                return fn.apply(that, arguments);
            };
        };

    },{"./_a-function":1}],11:[function(require,module,exports){
// 7.2.1 RequireObjectCoercible(argument)
        module.exports = function (it) {
            if (it == undefined) throw TypeError("Can't call method on  " + it);
            return it;
        };

    },{}],12:[function(require,module,exports){
// Thank's IE8 for his funny defineProperty
        module.exports = !require('./_fails')(function () {
            return Object.defineProperty({}, 'a', { get: function () { return 7; } }).a != 7;
        });

    },{"./_fails":18}],13:[function(require,module,exports){
        var isObject = require('./_is-object');
        var document = require('./_global').document;
// typeof document.createElement is 'object' in old IE
        var is = isObject(document) && isObject(document.createElement);
        module.exports = function (it) {
            return is ? document.createElement(it) : {};
        };

    },{"./_global":22,"./_is-object":31}],14:[function(require,module,exports){
// IE 8- don't enum bug keys
        module.exports = (
            'constructor,hasOwnProperty,isPrototypeOf,propertyIsEnumerable,toLocaleString,toString,valueOf'
        ).split(',');

    },{}],15:[function(require,module,exports){
// all enumerable object keys, includes symbols
        var getKeys = require('./_object-keys');
        var gOPS = require('./_object-gops');
        var pIE = require('./_object-pie');
        module.exports = function (it) {
            var result = getKeys(it);
            var getSymbols = gOPS.f;
            if (getSymbols) {
                var symbols = getSymbols(it);
                var isEnum = pIE.f;
                var i = 0;
                var key;
                while (symbols.length > i) if (isEnum.call(it, key = symbols[i++])) result.push(key);
            } return result;
        };

    },{"./_object-gops":47,"./_object-keys":50,"./_object-pie":51}],16:[function(require,module,exports){
        var global = require('./_global');
        var core = require('./_core');
        var hide = require('./_hide');
        var redefine = require('./_redefine');
        var ctx = require('./_ctx');
        var PROTOTYPE = 'prototype';

        var $export = function (type, name, source) {
            var IS_FORCED = type & $export.F;
            var IS_GLOBAL = type & $export.G;
            var IS_STATIC = type & $export.S;
            var IS_PROTO = type & $export.P;
            var IS_BIND = type & $export.B;
            var target = IS_GLOBAL ? global : IS_STATIC ? global[name] || (global[name] = {}) : (global[name] || {})[PROTOTYPE];
            var exports = IS_GLOBAL ? core : core[name] || (core[name] = {});
            var expProto = exports[PROTOTYPE] || (exports[PROTOTYPE] = {});
            var key, own, out, exp;
            if (IS_GLOBAL) source = name;
            for (key in source) {
                // contains in native
                own = !IS_FORCED && target && target[key] !== undefined;
                // export native or passed
                out = (own ? target : source)[key];
                // bind timers to global for call from export context
                exp = IS_BIND && own ? ctx(out, global) : IS_PROTO && typeof out == 'function' ? ctx(Function.call, out) : out;
                // extend global
                if (target) redefine(target, key, out, type & $export.U);
                // export
                if (exports[key] != out) hide(exports, key, exp);
                if (IS_PROTO && expProto[key] != out) expProto[key] = out;
            }
        };
        global.core = core;
// type bitmap
        $export.F = 1;   // forced
        $export.G = 2;   // global
        $export.S = 4;   // static
        $export.P = 8;   // proto
        $export.B = 16;  // bind
        $export.W = 32;  // wrap
        $export.U = 64;  // safe
        $export.R = 128; // real proto method for `library`
        module.exports = $export;

    },{"./_core":8,"./_ctx":10,"./_global":22,"./_hide":24,"./_redefine":54}],17:[function(require,module,exports){
        var MATCH = require('./_wks')('match');
        module.exports = function (KEY) {
            var re = /./;
            try {
                '/./'[KEY](re);
            } catch (e) {
                try {
                    re[MATCH] = false;
                    return !'/./'[KEY](re);
                } catch (f) { /* empty */ }
            } return true;
        };

    },{"./_wks":75}],18:[function(require,module,exports){
        module.exports = function (exec) {
            try {
                return !!exec();
            } catch (e) {
                return true;
            }
        };

    },{}],19:[function(require,module,exports){
        'use strict';
        require('./es6.regexp.exec');
        var redefine = require('./_redefine');
        var hide = require('./_hide');
        var fails = require('./_fails');
        var defined = require('./_defined');
        var wks = require('./_wks');
        var regexpExec = require('./_regexp-exec');

        var SPECIES = wks('species');

        var REPLACE_SUPPORTS_NAMED_GROUPS = !fails(function () {
            // #replace needs built-in support for named groups.
            // #match works fine because it just return the exec results, even if it has
            // a "grops" property.
            var re = /./;
            re.exec = function () {
                var result = [];
                result.groups = { a: '7' };
                return result;
            };
            return ''.replace(re, '$<a>') !== '7';
        });

        var SPLIT_WORKS_WITH_OVERWRITTEN_EXEC = (function () {
            // Chrome 51 has a buggy "split" implementation when RegExp#exec !== nativeExec
            var re = /(?:)/;
            var originalExec = re.exec;
            re.exec = function () { return originalExec.apply(this, arguments); };
            var result = 'ab'.split(re);
            return result.length === 2 && result[0] === 'a' && result[1] === 'b';
        })();

        module.exports = function (KEY, length, exec) {
            var SYMBOL = wks(KEY);

            var DELEGATES_TO_SYMBOL = !fails(function () {
                // String methods call symbol-named RegEp methods
                var O = {};
                O[SYMBOL] = function () { return 7; };
                return ''[KEY](O) != 7;
            });

            var DELEGATES_TO_EXEC = DELEGATES_TO_SYMBOL ? !fails(function () {
                // Symbol-named RegExp methods call .exec
                var execCalled = false;
                var re = /a/;
                re.exec = function () { execCalled = true; return null; };
                if (KEY === 'split') {
                    // RegExp[@@split] doesn't call the regex's exec method, but first creates
                    // a new one. We need to return the patched regex when creating the new one.
                    re.constructor = {};
                    re.constructor[SPECIES] = function () { return re; };
                }
                re[SYMBOL]('');
                return !execCalled;
            }) : undefined;

            if (
                !DELEGATES_TO_SYMBOL ||
                !DELEGATES_TO_EXEC ||
                (KEY === 'replace' && !REPLACE_SUPPORTS_NAMED_GROUPS) ||
                (KEY === 'split' && !SPLIT_WORKS_WITH_OVERWRITTEN_EXEC)
            ) {
                var nativeRegExpMethod = /./[SYMBOL];
                var fns = exec(
                    defined,
                    SYMBOL,
                    ''[KEY],
                    function maybeCallNative(nativeMethod, regexp, str, arg2, forceStringMethod) {
                        if (regexp.exec === regexpExec) {
                            if (DELEGATES_TO_SYMBOL && !forceStringMethod) {
                                // The native String method already delegates to @@method (this
                                // polyfilled function), leasing to infinite recursion.
                                // We avoid it by directly calling the native @@method method.
                                return { done: true, value: nativeRegExpMethod.call(regexp, str, arg2) };
                            }
                            return { done: true, value: nativeMethod.call(str, regexp, arg2) };
                        }
                        return { done: false };
                    }
                );
                var strfn = fns[0];
                var rxfn = fns[1];

                redefine(String.prototype, KEY, strfn);
                hide(RegExp.prototype, SYMBOL, length == 2
                    // 21.2.5.8 RegExp.prototype[@@replace](string, replaceValue)
                    // 21.2.5.11 RegExp.prototype[@@split](string, limit)
                    ? function (string, arg) { return rxfn.call(string, this, arg); }
                    // 21.2.5.6 RegExp.prototype[@@match](string)
                    // 21.2.5.9 RegExp.prototype[@@search](string)
                    : function (string) { return rxfn.call(string, this); }
                );
            }
        };

    },{"./_defined":11,"./_fails":18,"./_hide":24,"./_redefine":54,"./_regexp-exec":56,"./_wks":75,"./es6.regexp.exec":82}],20:[function(require,module,exports){
        'use strict';
// 21.2.5.3 get RegExp.prototype.flags
        var anObject = require('./_an-object');
        module.exports = function () {
            var that = anObject(this);
            var result = '';
            if (that.global) result += 'g';
            if (that.ignoreCase) result += 'i';
            if (that.multiline) result += 'm';
            if (that.unicode) result += 'u';
            if (that.sticky) result += 'y';
            return result;
        };

    },{"./_an-object":4}],21:[function(require,module,exports){
        module.exports = require('./_shared')('native-function-to-string', Function.toString);

    },{"./_shared":61}],22:[function(require,module,exports){
// https://github.com/zloirock/core-js/issues/86#issuecomment-115759028
        var global = module.exports = typeof window != 'undefined' && window.Math == Math
            ? window : typeof self != 'undefined' && self.Math == Math ? self
                // eslint-disable-next-line no-new-func
                : Function('return this')();
        if (typeof __g == 'number') __g = global; // eslint-disable-line no-undef

    },{}],23:[function(require,module,exports){
        var hasOwnProperty = {}.hasOwnProperty;
        module.exports = function (it, key) {
            return hasOwnProperty.call(it, key);
        };

    },{}],24:[function(require,module,exports){
        var dP = require('./_object-dp');
        var createDesc = require('./_property-desc');
        module.exports = require('./_descriptors') ? function (object, key, value) {
            return dP.f(object, key, createDesc(1, value));
        } : function (object, key, value) {
            object[key] = value;
            return object;
        };

    },{"./_descriptors":12,"./_object-dp":42,"./_property-desc":53}],25:[function(require,module,exports){
        var document = require('./_global').document;
        module.exports = document && document.documentElement;

    },{"./_global":22}],26:[function(require,module,exports){
        module.exports = !require('./_descriptors') && !require('./_fails')(function () {
            return Object.defineProperty(require('./_dom-create')('div'), 'a', { get: function () { return 7; } }).a != 7;
        });

    },{"./_descriptors":12,"./_dom-create":13,"./_fails":18}],27:[function(require,module,exports){
        var isObject = require('./_is-object');
        var setPrototypeOf = require('./_set-proto').set;
        module.exports = function (that, target, C) {
            var S = target.constructor;
            var P;
            if (S !== C && typeof S == 'function' && (P = S.prototype) !== C.prototype && isObject(P) && setPrototypeOf) {
                setPrototypeOf(that, P);
            } return that;
        };

    },{"./_is-object":31,"./_set-proto":57}],28:[function(require,module,exports){
// fallback for non-array-like ES3 and non-enumerable old V8 strings
        var cof = require('./_cof');
// eslint-disable-next-line no-prototype-builtins
        module.exports = Object('z').propertyIsEnumerable(0) ? Object : function (it) {
            return cof(it) == 'String' ? it.split('') : Object(it);
        };

    },{"./_cof":7}],29:[function(require,module,exports){
// check on default Array iterator
        var Iterators = require('./_iterators');
        var ITERATOR = require('./_wks')('iterator');
        var ArrayProto = Array.prototype;

        module.exports = function (it) {
            return it !== undefined && (Iterators.Array === it || ArrayProto[ITERATOR] === it);
        };

    },{"./_iterators":38,"./_wks":75}],30:[function(require,module,exports){
// 7.2.2 IsArray(argument)
        var cof = require('./_cof');
        module.exports = Array.isArray || function isArray(arg) {
            return cof(arg) == 'Array';
        };

    },{"./_cof":7}],31:[function(require,module,exports){
        module.exports = function (it) {
            return typeof it === 'object' ? it !== null : typeof it === 'function';
        };

    },{}],32:[function(require,module,exports){
// 7.2.8 IsRegExp(argument)
        var isObject = require('./_is-object');
        var cof = require('./_cof');
        var MATCH = require('./_wks')('match');
        module.exports = function (it) {
            var isRegExp;
            return isObject(it) && ((isRegExp = it[MATCH]) !== undefined ? !!isRegExp : cof(it) == 'RegExp');
        };

    },{"./_cof":7,"./_is-object":31,"./_wks":75}],33:[function(require,module,exports){
// call something on iterator step with safe closing on error
        var anObject = require('./_an-object');
        module.exports = function (iterator, fn, value, entries) {
            try {
                return entries ? fn(anObject(value)[0], value[1]) : fn(value);
                // 7.4.6 IteratorClose(iterator, completion)
            } catch (e) {
                var ret = iterator['return'];
                if (ret !== undefined) anObject(ret.call(iterator));
                throw e;
            }
        };

    },{"./_an-object":4}],34:[function(require,module,exports){
        'use strict';
        var create = require('./_object-create');
        var descriptor = require('./_property-desc');
        var setToStringTag = require('./_set-to-string-tag');
        var IteratorPrototype = {};

// 25.1.2.1.1 %IteratorPrototype%[@@iterator]()
        require('./_hide')(IteratorPrototype, require('./_wks')('iterator'), function () { return this; });

        module.exports = function (Constructor, NAME, next) {
            Constructor.prototype = create(IteratorPrototype, { next: descriptor(1, next) });
            setToStringTag(Constructor, NAME + ' Iterator');
        };

    },{"./_hide":24,"./_object-create":41,"./_property-desc":53,"./_set-to-string-tag":59,"./_wks":75}],35:[function(require,module,exports){
        'use strict';
        var LIBRARY = require('./_library');
        var $export = require('./_export');
        var redefine = require('./_redefine');
        var hide = require('./_hide');
        var Iterators = require('./_iterators');
        var $iterCreate = require('./_iter-create');
        var setToStringTag = require('./_set-to-string-tag');
        var getPrototypeOf = require('./_object-gpo');
        var ITERATOR = require('./_wks')('iterator');
        var BUGGY = !([].keys && 'next' in [].keys()); // Safari has buggy iterators w/o `next`
        var FF_ITERATOR = '@@iterator';
        var KEYS = 'keys';
        var VALUES = 'values';

        var returnThis = function () { return this; };

        module.exports = function (Base, NAME, Constructor, next, DEFAULT, IS_SET, FORCED) {
            $iterCreate(Constructor, NAME, next);
            var getMethod = function (kind) {
                if (!BUGGY && kind in proto) return proto[kind];
                switch (kind) {
                    case KEYS: return function keys() { return new Constructor(this, kind); };
                    case VALUES: return function values() { return new Constructor(this, kind); };
                } return function entries() { return new Constructor(this, kind); };
            };
            var TAG = NAME + ' Iterator';
            var DEF_VALUES = DEFAULT == VALUES;
            var VALUES_BUG = false;
            var proto = Base.prototype;
            var $native = proto[ITERATOR] || proto[FF_ITERATOR] || DEFAULT && proto[DEFAULT];
            var $default = $native || getMethod(DEFAULT);
            var $entries = DEFAULT ? !DEF_VALUES ? $default : getMethod('entries') : undefined;
            var $anyNative = NAME == 'Array' ? proto.entries || $native : $native;
            var methods, key, IteratorPrototype;
            // Fix native
            if ($anyNative) {
                IteratorPrototype = getPrototypeOf($anyNative.call(new Base()));
                if (IteratorPrototype !== Object.prototype && IteratorPrototype.next) {
                    // Set @@toStringTag to native iterators
                    setToStringTag(IteratorPrototype, TAG, true);
                    // fix for some old engines
                    if (!LIBRARY && typeof IteratorPrototype[ITERATOR] != 'function') hide(IteratorPrototype, ITERATOR, returnThis);
                }
            }
            // fix Array#{values, @@iterator}.name in V8 / FF
            if (DEF_VALUES && $native && $native.name !== VALUES) {
                VALUES_BUG = true;
                $default = function values() { return $native.call(this); };
            }
            // Define iterator
            if ((!LIBRARY || FORCED) && (BUGGY || VALUES_BUG || !proto[ITERATOR])) {
                hide(proto, ITERATOR, $default);
            }
            // Plug for library
            Iterators[NAME] = $default;
            Iterators[TAG] = returnThis;
            if (DEFAULT) {
                methods = {
                    values: DEF_VALUES ? $default : getMethod(VALUES),
                    keys: IS_SET ? $default : getMethod(KEYS),
                    entries: $entries
                };
                if (FORCED) for (key in methods) {
                    if (!(key in proto)) redefine(proto, key, methods[key]);
                } else $export($export.P + $export.F * (BUGGY || VALUES_BUG), NAME, methods);
            }
            return methods;
        };

    },{"./_export":16,"./_hide":24,"./_iter-create":34,"./_iterators":38,"./_library":39,"./_object-gpo":48,"./_redefine":54,"./_set-to-string-tag":59,"./_wks":75}],36:[function(require,module,exports){
        var ITERATOR = require('./_wks')('iterator');
        var SAFE_CLOSING = false;

        try {
            var riter = [7][ITERATOR]();
            riter['return'] = function () { SAFE_CLOSING = true; };
            // eslint-disable-next-line no-throw-literal
            Array.from(riter, function () { throw 2; });
        } catch (e) { /* empty */ }

        module.exports = function (exec, skipClosing) {
            if (!skipClosing && !SAFE_CLOSING) return false;
            var safe = false;
            try {
                var arr = [7];
                var iter = arr[ITERATOR]();
                iter.next = function () { return { done: safe = true }; };
                arr[ITERATOR] = function () { return iter; };
                exec(arr);
            } catch (e) { /* empty */ }
            return safe;
        };

    },{"./_wks":75}],37:[function(require,module,exports){
        module.exports = function (done, value) {
            return { value: value, done: !!done };
        };

    },{}],38:[function(require,module,exports){
        module.exports = {};

    },{}],39:[function(require,module,exports){
        module.exports = false;

    },{}],40:[function(require,module,exports){
        var META = require('./_uid')('meta');
        var isObject = require('./_is-object');
        var has = require('./_has');
        var setDesc = require('./_object-dp').f;
        var id = 0;
        var isExtensible = Object.isExtensible || function () {
            return true;
        };
        var FREEZE = !require('./_fails')(function () {
            return isExtensible(Object.preventExtensions({}));
        });
        var setMeta = function (it) {
            setDesc(it, META, { value: {
                    i: 'O' + ++id, // object ID
                    w: {}          // weak collections IDs
                } });
        };
        var fastKey = function (it, create) {
            // return primitive with prefix
            if (!isObject(it)) return typeof it == 'symbol' ? it : (typeof it == 'string' ? 'S' : 'P') + it;
            if (!has(it, META)) {
                // can't set metadata to uncaught frozen object
                if (!isExtensible(it)) return 'F';
                // not necessary to add metadata
                if (!create) return 'E';
                // add missing metadata
                setMeta(it);
                // return object ID
            } return it[META].i;
        };
        var getWeak = function (it, create) {
            if (!has(it, META)) {
                // can't set metadata to uncaught frozen object
                if (!isExtensible(it)) return true;
                // not necessary to add metadata
                if (!create) return false;
                // add missing metadata
                setMeta(it);
                // return hash weak collections IDs
            } return it[META].w;
        };
// add metadata on freeze-family methods calling
        var onFreeze = function (it) {
            if (FREEZE && meta.NEED && isExtensible(it) && !has(it, META)) setMeta(it);
            return it;
        };
        var meta = module.exports = {
            KEY: META,
            NEED: false,
            fastKey: fastKey,
            getWeak: getWeak,
            onFreeze: onFreeze
        };

    },{"./_fails":18,"./_has":23,"./_is-object":31,"./_object-dp":42,"./_uid":72}],41:[function(require,module,exports){
// 19.1.2.2 / 15.2.3.5 Object.create(O [, Properties])
        var anObject = require('./_an-object');
        var dPs = require('./_object-dps');
        var enumBugKeys = require('./_enum-bug-keys');
        var IE_PROTO = require('./_shared-key')('IE_PROTO');
        var Empty = function () { /* empty */ };
        var PROTOTYPE = 'prototype';

// Create object with fake `null` prototype: use iframe Object with cleared prototype
        var createDict = function () {
            // Thrash, waste and sodomy: IE GC bug
            var iframe = require('./_dom-create')('iframe');
            var i = enumBugKeys.length;
            var lt = '<';
            var gt = '>';
            var iframeDocument;
            iframe.style.display = 'none';
            require('./_html').appendChild(iframe);
            iframe.src = 'javascript:'; // eslint-disable-line no-script-url
            // createDict = iframe.contentWindow.Object;
            // html.removeChild(iframe);
            iframeDocument = iframe.contentWindow.document;
            iframeDocument.open();
            iframeDocument.write(lt + 'script' + gt + 'document.F=Object' + lt + '/script' + gt);
            iframeDocument.close();
            createDict = iframeDocument.F;
            while (i--) delete createDict[PROTOTYPE][enumBugKeys[i]];
            return createDict();
        };

        module.exports = Object.create || function create(O, Properties) {
            var result;
            if (O !== null) {
                Empty[PROTOTYPE] = anObject(O);
                result = new Empty();
                Empty[PROTOTYPE] = null;
                // add "__proto__" for Object.getPrototypeOf polyfill
                result[IE_PROTO] = O;
            } else result = createDict();
            return Properties === undefined ? result : dPs(result, Properties);
        };

    },{"./_an-object":4,"./_dom-create":13,"./_enum-bug-keys":14,"./_html":25,"./_object-dps":43,"./_shared-key":60}],42:[function(require,module,exports){
        var anObject = require('./_an-object');
        var IE8_DOM_DEFINE = require('./_ie8-dom-define');
        var toPrimitive = require('./_to-primitive');
        var dP = Object.defineProperty;

        exports.f = require('./_descriptors') ? Object.defineProperty : function defineProperty(O, P, Attributes) {
            anObject(O);
            P = toPrimitive(P, true);
            anObject(Attributes);
            if (IE8_DOM_DEFINE) try {
                return dP(O, P, Attributes);
            } catch (e) { /* empty */ }
            if ('get' in Attributes || 'set' in Attributes) throw TypeError('Accessors not supported!');
            if ('value' in Attributes) O[P] = Attributes.value;
            return O;
        };

    },{"./_an-object":4,"./_descriptors":12,"./_ie8-dom-define":26,"./_to-primitive":71}],43:[function(require,module,exports){
        var dP = require('./_object-dp');
        var anObject = require('./_an-object');
        var getKeys = require('./_object-keys');

        module.exports = require('./_descriptors') ? Object.defineProperties : function defineProperties(O, Properties) {
            anObject(O);
            var keys = getKeys(Properties);
            var length = keys.length;
            var i = 0;
            var P;
            while (length > i) dP.f(O, P = keys[i++], Properties[P]);
            return O;
        };

    },{"./_an-object":4,"./_descriptors":12,"./_object-dp":42,"./_object-keys":50}],44:[function(require,module,exports){
        var pIE = require('./_object-pie');
        var createDesc = require('./_property-desc');
        var toIObject = require('./_to-iobject');
        var toPrimitive = require('./_to-primitive');
        var has = require('./_has');
        var IE8_DOM_DEFINE = require('./_ie8-dom-define');
        var gOPD = Object.getOwnPropertyDescriptor;

        exports.f = require('./_descriptors') ? gOPD : function getOwnPropertyDescriptor(O, P) {
            O = toIObject(O);
            P = toPrimitive(P, true);
            if (IE8_DOM_DEFINE) try {
                return gOPD(O, P);
            } catch (e) { /* empty */ }
            if (has(O, P)) return createDesc(!pIE.f.call(O, P), O[P]);
        };

    },{"./_descriptors":12,"./_has":23,"./_ie8-dom-define":26,"./_object-pie":51,"./_property-desc":53,"./_to-iobject":68,"./_to-primitive":71}],45:[function(require,module,exports){
// fallback for IE11 buggy Object.getOwnPropertyNames with iframe and window
        var toIObject = require('./_to-iobject');
        var gOPN = require('./_object-gopn').f;
        var toString = {}.toString;

        var windowNames = typeof window == 'object' && window && Object.getOwnPropertyNames
            ? Object.getOwnPropertyNames(window) : [];

        var getWindowNames = function (it) {
            try {
                return gOPN(it);
            } catch (e) {
                return windowNames.slice();
            }
        };

        module.exports.f = function getOwnPropertyNames(it) {
            return windowNames && toString.call(it) == '[object Window]' ? getWindowNames(it) : gOPN(toIObject(it));
        };

    },{"./_object-gopn":46,"./_to-iobject":68}],46:[function(require,module,exports){
// 19.1.2.7 / 15.2.3.4 Object.getOwnPropertyNames(O)
        var $keys = require('./_object-keys-internal');
        var hiddenKeys = require('./_enum-bug-keys').concat('length', 'prototype');

        exports.f = Object.getOwnPropertyNames || function getOwnPropertyNames(O) {
            return $keys(O, hiddenKeys);
        };

    },{"./_enum-bug-keys":14,"./_object-keys-internal":49}],47:[function(require,module,exports){
        exports.f = Object.getOwnPropertySymbols;

    },{}],48:[function(require,module,exports){
// 19.1.2.9 / 15.2.3.2 Object.getPrototypeOf(O)
        var has = require('./_has');
        var toObject = require('./_to-object');
        var IE_PROTO = require('./_shared-key')('IE_PROTO');
        var ObjectProto = Object.prototype;

        module.exports = Object.getPrototypeOf || function (O) {
            O = toObject(O);
            if (has(O, IE_PROTO)) return O[IE_PROTO];
            if (typeof O.constructor == 'function' && O instanceof O.constructor) {
                return O.constructor.prototype;
            } return O instanceof Object ? ObjectProto : null;
        };

    },{"./_has":23,"./_shared-key":60,"./_to-object":70}],49:[function(require,module,exports){
        var has = require('./_has');
        var toIObject = require('./_to-iobject');
        var arrayIndexOf = require('./_array-includes')(false);
        var IE_PROTO = require('./_shared-key')('IE_PROTO');

        module.exports = function (object, names) {
            var O = toIObject(object);
            var i = 0;
            var result = [];
            var key;
            for (key in O) if (key != IE_PROTO) has(O, key) && result.push(key);
            // Don't enum bug & hidden keys
            while (names.length > i) if (has(O, key = names[i++])) {
                ~arrayIndexOf(result, key) || result.push(key);
            }
            return result;
        };

    },{"./_array-includes":5,"./_has":23,"./_shared-key":60,"./_to-iobject":68}],50:[function(require,module,exports){
// 19.1.2.14 / 15.2.3.14 Object.keys(O)
        var $keys = require('./_object-keys-internal');
        var enumBugKeys = require('./_enum-bug-keys');

        module.exports = Object.keys || function keys(O) {
            return $keys(O, enumBugKeys);
        };

    },{"./_enum-bug-keys":14,"./_object-keys-internal":49}],51:[function(require,module,exports){
        exports.f = {}.propertyIsEnumerable;

    },{}],52:[function(require,module,exports){
// most Object methods by ES6 should accept primitives
        var $export = require('./_export');
        var core = require('./_core');
        var fails = require('./_fails');
        module.exports = function (KEY, exec) {
            var fn = (core.Object || {})[KEY] || Object[KEY];
            var exp = {};
            exp[KEY] = exec(fn);
            $export($export.S + $export.F * fails(function () { fn(1); }), 'Object', exp);
        };

    },{"./_core":8,"./_export":16,"./_fails":18}],53:[function(require,module,exports){
        module.exports = function (bitmap, value) {
            return {
                enumerable: !(bitmap & 1),
                configurable: !(bitmap & 2),
                writable: !(bitmap & 4),
                value: value
            };
        };

    },{}],54:[function(require,module,exports){
        var global = require('./_global');
        var hide = require('./_hide');
        var has = require('./_has');
        var SRC = require('./_uid')('src');
        var $toString = require('./_function-to-string');
        var TO_STRING = 'toString';
        var TPL = ('' + $toString).split(TO_STRING);

        require('./_core').inspectSource = function (it) {
            return $toString.call(it);
        };

        (module.exports = function (O, key, val, safe) {
            var isFunction = typeof val == 'function';
            if (isFunction) has(val, 'name') || hide(val, 'name', key);
            if (O[key] === val) return;
            if (isFunction) has(val, SRC) || hide(val, SRC, O[key] ? '' + O[key] : TPL.join(String(key)));
            if (O === global) {
                O[key] = val;
            } else if (!safe) {
                delete O[key];
                hide(O, key, val);
            } else if (O[key]) {
                O[key] = val;
            } else {
                hide(O, key, val);
            }
// add fake Function#toString for correct work wrapped methods / constructors with methods like LoDash isNative
        })(Function.prototype, TO_STRING, function toString() {
            return typeof this == 'function' && this[SRC] || $toString.call(this);
        });

    },{"./_core":8,"./_function-to-string":21,"./_global":22,"./_has":23,"./_hide":24,"./_uid":72}],55:[function(require,module,exports){
        'use strict';

        var classof = require('./_classof');
        var builtinExec = RegExp.prototype.exec;

        // `RegExpExec` abstract operation
// https://tc39.github.io/ecma262/#sec-regexpexec
        module.exports = function (R, S) {
            var exec = R.exec;
            if (typeof exec === 'function') {
                var result = exec.call(R, S);
                if (typeof result !== 'object') {
                    throw new TypeError('RegExp exec method returned something other than an Object or null');
                }
                return result;
            }
            if (classof(R) !== 'RegExp') {
                throw new TypeError('RegExp#exec called on incompatible receiver');
            }
            return builtinExec.call(R, S);
        };

    },{"./_classof":6}],56:[function(require,module,exports){
        'use strict';

        var regexpFlags = require('./_flags');

        var nativeExec = RegExp.prototype.exec;
// This always refers to the native implementation, because the
// String#replace polyfill uses ./fix-regexp-well-known-symbol-logic.js,
// which loads this file before patching the method.
        var nativeReplace = String.prototype.replace;

        var patchedExec = nativeExec;

        var LAST_INDEX = 'lastIndex';

        var UPDATES_LAST_INDEX_WRONG = (function () {
            var re1 = /a/,
                re2 = /b*/g;
            nativeExec.call(re1, 'a');
            nativeExec.call(re2, 'a');
            return re1[LAST_INDEX] !== 0 || re2[LAST_INDEX] !== 0;
        })();

// nonparticipating capturing group, copied from es5-shim's String#split patch.
        var NPCG_INCLUDED = /()??/.exec('')[1] !== undefined;

        var PATCH = UPDATES_LAST_INDEX_WRONG || NPCG_INCLUDED;

        if (PATCH) {
            patchedExec = function exec(str) {
                var re = this;
                var lastIndex, reCopy, match, i;

                if (NPCG_INCLUDED) {
                    reCopy = new RegExp('^' + re.source + '$(?!\\s)', regexpFlags.call(re));
                }
                if (UPDATES_LAST_INDEX_WRONG) lastIndex = re[LAST_INDEX];

                match = nativeExec.call(re, str);

                if (UPDATES_LAST_INDEX_WRONG && match) {
                    re[LAST_INDEX] = re.global ? match.index + match[0].length : lastIndex;
                }
                if (NPCG_INCLUDED && match && match.length > 1) {
                    // Fix browsers whose `exec` methods don't consistently return `undefined`
                    // for NPCG, like IE8. NOTE: This doesn' work for /(.?)?/
                    // eslint-disable-next-line no-loop-func
                    nativeReplace.call(match[0], reCopy, function () {
                        for (i = 1; i < arguments.length - 2; i++) {
                            if (arguments[i] === undefined) match[i] = undefined;
                        }
                    });
                }

                return match;
            };
        }

        module.exports = patchedExec;

    },{"./_flags":20}],57:[function(require,module,exports){
// Works with __proto__ only. Old v8 can't work with null proto objects.
        /* eslint-disable no-proto */
        var isObject = require('./_is-object');
        var anObject = require('./_an-object');
        var check = function (O, proto) {
            anObject(O);
            if (!isObject(proto) && proto !== null) throw TypeError(proto + ": can't set as prototype!");
        };
        module.exports = {
            set: Object.setPrototypeOf || ('__proto__' in {} ? // eslint-disable-line
                function (test, buggy, set) {
                    try {
                        set = require('./_ctx')(Function.call, require('./_object-gopd').f(Object.prototype, '__proto__').set, 2);
                        set(test, []);
                        buggy = !(test instanceof Array);
                    } catch (e) { buggy = true; }
                    return function setPrototypeOf(O, proto) {
                        check(O, proto);
                        if (buggy) O.__proto__ = proto;
                        else set(O, proto);
                        return O;
                    };
                }({}, false) : undefined),
            check: check
        };

    },{"./_an-object":4,"./_ctx":10,"./_is-object":31,"./_object-gopd":44}],58:[function(require,module,exports){
        'use strict';
        var global = require('./_global');
        var dP = require('./_object-dp');
        var DESCRIPTORS = require('./_descriptors');
        var SPECIES = require('./_wks')('species');

        module.exports = function (KEY) {
            var C = global[KEY];
            if (DESCRIPTORS && C && !C[SPECIES]) dP.f(C, SPECIES, {
                configurable: true,
                get: function () { return this; }
            });
        };

    },{"./_descriptors":12,"./_global":22,"./_object-dp":42,"./_wks":75}],59:[function(require,module,exports){
        var def = require('./_object-dp').f;
        var has = require('./_has');
        var TAG = require('./_wks')('toStringTag');

        module.exports = function (it, tag, stat) {
            if (it && !has(it = stat ? it : it.prototype, TAG)) def(it, TAG, { configurable: true, value: tag });
        };

    },{"./_has":23,"./_object-dp":42,"./_wks":75}],60:[function(require,module,exports){
        var shared = require('./_shared')('keys');
        var uid = require('./_uid');
        module.exports = function (key) {
            return shared[key] || (shared[key] = uid(key));
        };

    },{"./_shared":61,"./_uid":72}],61:[function(require,module,exports){
        var core = require('./_core');
        var global = require('./_global');
        var SHARED = '__core-js_shared__';
        var store = global[SHARED] || (global[SHARED] = {});

        (module.exports = function (key, value) {
            return store[key] || (store[key] = value !== undefined ? value : {});
        })('versions', []).push({
            version: core.version,
            mode: require('./_library') ? 'pure' : 'global',
            copyright: '© 2019 Denis Pushkarev (zloirock.ru)'
        });

    },{"./_core":8,"./_global":22,"./_library":39}],62:[function(require,module,exports){
// 7.3.20 SpeciesConstructor(O, defaultConstructor)
        var anObject = require('./_an-object');
        var aFunction = require('./_a-function');
        var SPECIES = require('./_wks')('species');
        module.exports = function (O, D) {
            var C = anObject(O).constructor;
            var S;
            return C === undefined || (S = anObject(C)[SPECIES]) == undefined ? D : aFunction(S);
        };

    },{"./_a-function":1,"./_an-object":4,"./_wks":75}],63:[function(require,module,exports){
        var toInteger = require('./_to-integer');
        var defined = require('./_defined');
// true  -> String#at
// false -> String#codePointAt
        module.exports = function (TO_STRING) {
            return function (that, pos) {
                var s = String(defined(that));
                var i = toInteger(pos);
                var l = s.length;
                var a, b;
                if (i < 0 || i >= l) return TO_STRING ? '' : undefined;
                a = s.charCodeAt(i);
                return a < 0xd800 || a > 0xdbff || i + 1 === l || (b = s.charCodeAt(i + 1)) < 0xdc00 || b > 0xdfff
                    ? TO_STRING ? s.charAt(i) : a
                    : TO_STRING ? s.slice(i, i + 2) : (a - 0xd800 << 10) + (b - 0xdc00) + 0x10000;
            };
        };

    },{"./_defined":11,"./_to-integer":67}],64:[function(require,module,exports){
// helper for String#{startsWith, endsWith, includes}
        var isRegExp = require('./_is-regexp');
        var defined = require('./_defined');

        module.exports = function (that, searchString, NAME) {
            if (isRegExp(searchString)) throw TypeError('String#' + NAME + " doesn't accept regex!");
            return String(defined(that));
        };

    },{"./_defined":11,"./_is-regexp":32}],65:[function(require,module,exports){
        var $export = require('./_export');
        var fails = require('./_fails');
        var defined = require('./_defined');
        var quot = /"/g;
// B.2.3.2.1 CreateHTML(string, tag, attribute, value)
        var createHTML = function (string, tag, attribute, value) {
            var S = String(defined(string));
            var p1 = '<' + tag;
            if (attribute !== '') p1 += ' ' + attribute + '="' + String(value).replace(quot, '&quot;') + '"';
            return p1 + '>' + S + '</' + tag + '>';
        };
        module.exports = function (NAME, exec) {
            var O = {};
            O[NAME] = exec(createHTML);
            $export($export.P + $export.F * fails(function () {
                var test = ''[NAME]('"');
                return test !== test.toLowerCase() || test.split('"').length > 3;
            }), 'String', O);
        };

    },{"./_defined":11,"./_export":16,"./_fails":18}],66:[function(require,module,exports){
        var toInteger = require('./_to-integer');
        var max = Math.max;
        var min = Math.min;
        module.exports = function (index, length) {
            index = toInteger(index);
            return index < 0 ? max(index + length, 0) : min(index, length);
        };

    },{"./_to-integer":67}],67:[function(require,module,exports){
// 7.1.4 ToInteger
        var ceil = Math.ceil;
        var floor = Math.floor;
        module.exports = function (it) {
            return isNaN(it = +it) ? 0 : (it > 0 ? floor : ceil)(it);
        };

    },{}],68:[function(require,module,exports){
// to indexed object, toObject with fallback for non-array-like ES3 strings
        var IObject = require('./_iobject');
        var defined = require('./_defined');
        module.exports = function (it) {
            return IObject(defined(it));
        };

    },{"./_defined":11,"./_iobject":28}],69:[function(require,module,exports){
// 7.1.15 ToLength
        var toInteger = require('./_to-integer');
        var min = Math.min;
        module.exports = function (it) {
            return it > 0 ? min(toInteger(it), 0x1fffffffffffff) : 0; // pow(2, 53) - 1 == 9007199254740991
        };

    },{"./_to-integer":67}],70:[function(require,module,exports){
// 7.1.13 ToObject(argument)
        var defined = require('./_defined');
        module.exports = function (it) {
            return Object(defined(it));
        };

    },{"./_defined":11}],71:[function(require,module,exports){
// 7.1.1 ToPrimitive(input [, PreferredType])
        var isObject = require('./_is-object');
// instead of the ES6 spec version, we didn't implement @@toPrimitive case
// and the second argument - flag - preferred type is a string
        module.exports = function (it, S) {
            if (!isObject(it)) return it;
            var fn, val;
            if (S && typeof (fn = it.toString) == 'function' && !isObject(val = fn.call(it))) return val;
            if (typeof (fn = it.valueOf) == 'function' && !isObject(val = fn.call(it))) return val;
            if (!S && typeof (fn = it.toString) == 'function' && !isObject(val = fn.call(it))) return val;
            throw TypeError("Can't convert object to primitive value");
        };

    },{"./_is-object":31}],72:[function(require,module,exports){
        var id = 0;
        var px = Math.random();
        module.exports = function (key) {
            return 'Symbol('.concat(key === undefined ? '' : key, ')_', (++id + px).toString(36));
        };

    },{}],73:[function(require,module,exports){
        var global = require('./_global');
        var core = require('./_core');
        var LIBRARY = require('./_library');
        var wksExt = require('./_wks-ext');
        var defineProperty = require('./_object-dp').f;
        module.exports = function (name) {
            var $Symbol = core.Symbol || (core.Symbol = LIBRARY ? {} : global.Symbol || {});
            if (name.charAt(0) != '_' && !(name in $Symbol)) defineProperty($Symbol, name, { value: wksExt.f(name) });
        };

    },{"./_core":8,"./_global":22,"./_library":39,"./_object-dp":42,"./_wks-ext":74}],74:[function(require,module,exports){
        exports.f = require('./_wks');

    },{"./_wks":75}],75:[function(require,module,exports){
        var store = require('./_shared')('wks');
        var uid = require('./_uid');
        var Symbol = require('./_global').Symbol;
        var USE_SYMBOL = typeof Symbol == 'function';

        var $exports = module.exports = function (name) {
            return store[name] || (store[name] =
                USE_SYMBOL && Symbol[name] || (USE_SYMBOL ? Symbol : uid)('Symbol.' + name));
        };

        $exports.store = store;

    },{"./_global":22,"./_shared":61,"./_uid":72}],76:[function(require,module,exports){
        var classof = require('./_classof');
        var ITERATOR = require('./_wks')('iterator');
        var Iterators = require('./_iterators');
        module.exports = require('./_core').getIteratorMethod = function (it) {
            if (it != undefined) return it[ITERATOR]
                || it['@@iterator']
                || Iterators[classof(it)];
        };

    },{"./_classof":6,"./_core":8,"./_iterators":38,"./_wks":75}],77:[function(require,module,exports){
        'use strict';
        var ctx = require('./_ctx');
        var $export = require('./_export');
        var toObject = require('./_to-object');
        var call = require('./_iter-call');
        var isArrayIter = require('./_is-array-iter');
        var toLength = require('./_to-length');
        var createProperty = require('./_create-property');
        var getIterFn = require('./core.get-iterator-method');

        $export($export.S + $export.F * !require('./_iter-detect')(function (iter) { Array.from(iter); }), 'Array', {
            // 22.1.2.1 Array.from(arrayLike, mapfn = undefined, thisArg = undefined)
            from: function from(arrayLike /* , mapfn = undefined, thisArg = undefined */) {
                var O = toObject(arrayLike);
                var C = typeof this == 'function' ? this : Array;
                var aLen = arguments.length;
                var mapfn = aLen > 1 ? arguments[1] : undefined;
                var mapping = mapfn !== undefined;
                var index = 0;
                var iterFn = getIterFn(O);
                var length, result, step, iterator;
                if (mapping) mapfn = ctx(mapfn, aLen > 2 ? arguments[2] : undefined, 2);
                // if object isn't iterable or it's array with default iterator - use simple case
                if (iterFn != undefined && !(C == Array && isArrayIter(iterFn))) {
                    for (iterator = iterFn.call(O), result = new C(); !(step = iterator.next()).done; index++) {
                        createProperty(result, index, mapping ? call(iterator, mapfn, [step.value, index], true) : step.value);
                    }
                } else {
                    length = toLength(O.length);
                    for (result = new C(length); length > index; index++) {
                        createProperty(result, index, mapping ? mapfn(O[index], index) : O[index]);
                    }
                }
                result.length = index;
                return result;
            }
        });

    },{"./_create-property":9,"./_ctx":10,"./_export":16,"./_is-array-iter":29,"./_iter-call":33,"./_iter-detect":36,"./_to-length":69,"./_to-object":70,"./core.get-iterator-method":76}],78:[function(require,module,exports){
        'use strict';
        var addToUnscopables = require('./_add-to-unscopables');
        var step = require('./_iter-step');
        var Iterators = require('./_iterators');
        var toIObject = require('./_to-iobject');

// 22.1.3.4 Array.prototype.entries()
// 22.1.3.13 Array.prototype.keys()
// 22.1.3.29 Array.prototype.values()
// 22.1.3.30 Array.prototype[@@iterator]()
        module.exports = require('./_iter-define')(Array, 'Array', function (iterated, kind) {
            this._t = toIObject(iterated); // target
            this._i = 0;                   // next index
            this._k = kind;                // kind
// 22.1.5.2.1 %ArrayIteratorPrototype%.next()
        }, function () {
            var O = this._t;
            var kind = this._k;
            var index = this._i++;
            if (!O || index >= O.length) {
                this._t = undefined;
                return step(1);
            }
            if (kind == 'keys') return step(0, index);
            if (kind == 'values') return step(0, O[index]);
            return step(0, [index, O[index]]);
        }, 'values');

// argumentsList[@@iterator] is %ArrayProto_values% (9.4.4.6, 9.4.4.7)
        Iterators.Arguments = Iterators.Array;

        addToUnscopables('keys');
        addToUnscopables('values');
        addToUnscopables('entries');

    },{"./_add-to-unscopables":2,"./_iter-define":35,"./_iter-step":37,"./_iterators":38,"./_to-iobject":68}],79:[function(require,module,exports){
// 19.1.2.14 Object.keys(O)
        var toObject = require('./_to-object');
        var $keys = require('./_object-keys');

        require('./_object-sap')('keys', function () {
            return function keys(it) {
                return $keys(toObject(it));
            };
        });

    },{"./_object-keys":50,"./_object-sap":52,"./_to-object":70}],80:[function(require,module,exports){
        'use strict';
// 19.1.3.6 Object.prototype.toString()
        var classof = require('./_classof');
        var test = {};
        test[require('./_wks')('toStringTag')] = 'z';
        if (test + '' != '[object z]') {
            require('./_redefine')(Object.prototype, 'toString', function toString() {
                return '[object ' + classof(this) + ']';
            }, true);
        }

    },{"./_classof":6,"./_redefine":54,"./_wks":75}],81:[function(require,module,exports){
        var global = require('./_global');
        var inheritIfRequired = require('./_inherit-if-required');
        var dP = require('./_object-dp').f;
        var gOPN = require('./_object-gopn').f;
        var isRegExp = require('./_is-regexp');
        var $flags = require('./_flags');
        var $RegExp = global.RegExp;
        var Base = $RegExp;
        var proto = $RegExp.prototype;
        var re1 = /a/g;
        var re2 = /a/g;
// "new" creates a new object, old webkit buggy here
        var CORRECT_NEW = new $RegExp(re1) !== re1;

        if (require('./_descriptors') && (!CORRECT_NEW || require('./_fails')(function () {
            re2[require('./_wks')('match')] = false;
            // RegExp constructor can alter flags and IsRegExp works correct with @@match
            return $RegExp(re1) != re1 || $RegExp(re2) == re2 || $RegExp(re1, 'i') != '/a/i';
        }))) {
            $RegExp = function RegExp(p, f) {
                var tiRE = this instanceof $RegExp;
                var piRE = isRegExp(p);
                var fiU = f === undefined;
                return !tiRE && piRE && p.constructor === $RegExp && fiU ? p
                    : inheritIfRequired(CORRECT_NEW
                        ? new Base(piRE && !fiU ? p.source : p, f)
                        : Base((piRE = p instanceof $RegExp) ? p.source : p, piRE && fiU ? $flags.call(p) : f)
                        , tiRE ? this : proto, $RegExp);
            };
            var proxy = function (key) {
                key in $RegExp || dP($RegExp, key, {
                    configurable: true,
                    get: function () { return Base[key]; },
                    set: function (it) { Base[key] = it; }
                });
            };
            for (var keys = gOPN(Base), i = 0; keys.length > i;) proxy(keys[i++]);
            proto.constructor = $RegExp;
            $RegExp.prototype = proto;
            require('./_redefine')(global, 'RegExp', $RegExp);
        }

        require('./_set-species')('RegExp');

    },{"./_descriptors":12,"./_fails":18,"./_flags":20,"./_global":22,"./_inherit-if-required":27,"./_is-regexp":32,"./_object-dp":42,"./_object-gopn":46,"./_redefine":54,"./_set-species":58,"./_wks":75}],82:[function(require,module,exports){
        'use strict';
        var regexpExec = require('./_regexp-exec');
        require('./_export')({
            target: 'RegExp',
            proto: true,
            forced: regexpExec !== /./.exec
        }, {
            exec: regexpExec
        });

    },{"./_export":16,"./_regexp-exec":56}],83:[function(require,module,exports){
// 21.2.5.3 get RegExp.prototype.flags()
        if (require('./_descriptors') && /./g.flags != 'g') require('./_object-dp').f(RegExp.prototype, 'flags', {
            configurable: true,
            get: require('./_flags')
        });

    },{"./_descriptors":12,"./_flags":20,"./_object-dp":42}],84:[function(require,module,exports){
        'use strict';

        var anObject = require('./_an-object');
        var toLength = require('./_to-length');
        var advanceStringIndex = require('./_advance-string-index');
        var regExpExec = require('./_regexp-exec-abstract');

// @@match logic
        require('./_fix-re-wks')('match', 1, function (defined, MATCH, $match, maybeCallNative) {
            return [
                // `String.prototype.match` method
                // https://tc39.github.io/ecma262/#sec-string.prototype.match
                function match(regexp) {
                    var O = defined(this);
                    var fn = regexp == undefined ? undefined : regexp[MATCH];
                    return fn !== undefined ? fn.call(regexp, O) : new RegExp(regexp)[MATCH](String(O));
                },
                // `RegExp.prototype[@@match]` method
                // https://tc39.github.io/ecma262/#sec-regexp.prototype-@@match
                function (regexp) {
                    var res = maybeCallNative($match, regexp, this);
                    if (res.done) return res.value;
                    var rx = anObject(regexp);
                    var S = String(this);
                    if (!rx.global) return regExpExec(rx, S);
                    var fullUnicode = rx.unicode;
                    rx.lastIndex = 0;
                    var A = [];
                    var n = 0;
                    var result;
                    while ((result = regExpExec(rx, S)) !== null) {
                        var matchStr = String(result[0]);
                        A[n] = matchStr;
                        if (matchStr === '') rx.lastIndex = advanceStringIndex(S, toLength(rx.lastIndex), fullUnicode);
                        n++;
                    }
                    return n === 0 ? null : A;
                }
            ];
        });

    },{"./_advance-string-index":3,"./_an-object":4,"./_fix-re-wks":19,"./_regexp-exec-abstract":55,"./_to-length":69}],85:[function(require,module,exports){
        'use strict';

        var anObject = require('./_an-object');
        var toObject = require('./_to-object');
        var toLength = require('./_to-length');
        var toInteger = require('./_to-integer');
        var advanceStringIndex = require('./_advance-string-index');
        var regExpExec = require('./_regexp-exec-abstract');
        var max = Math.max;
        var min = Math.min;
        var floor = Math.floor;
        var SUBSTITUTION_SYMBOLS = /\$([$&`']|\d\d?|<[^>]*>)/g;
        var SUBSTITUTION_SYMBOLS_NO_NAMED = /\$([$&`']|\d\d?)/g;

        var maybeToString = function (it) {
            return it === undefined ? it : String(it);
        };

// @@replace logic
        require('./_fix-re-wks')('replace', 2, function (defined, REPLACE, $replace, maybeCallNative) {
            return [
                // `String.prototype.replace` method
                // https://tc39.github.io/ecma262/#sec-string.prototype.replace
                function replace(searchValue, replaceValue) {
                    var O = defined(this);
                    var fn = searchValue == undefined ? undefined : searchValue[REPLACE];
                    return fn !== undefined
                        ? fn.call(searchValue, O, replaceValue)
                        : $replace.call(String(O), searchValue, replaceValue);
                },
                // `RegExp.prototype[@@replace]` method
                // https://tc39.github.io/ecma262/#sec-regexp.prototype-@@replace
                function (regexp, replaceValue) {
                    var res = maybeCallNative($replace, regexp, this, replaceValue);
                    if (res.done) return res.value;

                    var rx = anObject(regexp);
                    var S = String(this);
                    var functionalReplace = typeof replaceValue === 'function';
                    if (!functionalReplace) replaceValue = String(replaceValue);
                    var global = rx.global;
                    if (global) {
                        var fullUnicode = rx.unicode;
                        rx.lastIndex = 0;
                    }
                    var results = [];
                    while (true) {
                        var result = regExpExec(rx, S);
                        if (result === null) break;
                        results.push(result);
                        if (!global) break;
                        var matchStr = String(result[0]);
                        if (matchStr === '') rx.lastIndex = advanceStringIndex(S, toLength(rx.lastIndex), fullUnicode);
                    }
                    var accumulatedResult = '';
                    var nextSourcePosition = 0;
                    for (var i = 0; i < results.length; i++) {
                        result = results[i];
                        var matched = String(result[0]);
                        var position = max(min(toInteger(result.index), S.length), 0);
                        var captures = [];
                        // NOTE: This is equivalent to
                        //   captures = result.slice(1).map(maybeToString)
                        // but for some reason `nativeSlice.call(result, 1, result.length)` (called in
                        // the slice polyfill when slicing native arrays) "doesn't work" in safari 9 and
                        // causes a crash (https://pastebin.com/N21QzeQA) when trying to debug it.
                        for (var j = 1; j < result.length; j++) captures.push(maybeToString(result[j]));
                        var namedCaptures = result.groups;
                        if (functionalReplace) {
                            var replacerArgs = [matched].concat(captures, position, S);
                            if (namedCaptures !== undefined) replacerArgs.push(namedCaptures);
                            var replacement = String(replaceValue.apply(undefined, replacerArgs));
                        } else {
                            replacement = getSubstitution(matched, S, position, captures, namedCaptures, replaceValue);
                        }
                        if (position >= nextSourcePosition) {
                            accumulatedResult += S.slice(nextSourcePosition, position) + replacement;
                            nextSourcePosition = position + matched.length;
                        }
                    }
                    return accumulatedResult + S.slice(nextSourcePosition);
                }
            ];

            // https://tc39.github.io/ecma262/#sec-getsubstitution
            function getSubstitution(matched, str, position, captures, namedCaptures, replacement) {
                var tailPos = position + matched.length;
                var m = captures.length;
                var symbols = SUBSTITUTION_SYMBOLS_NO_NAMED;
                if (namedCaptures !== undefined) {
                    namedCaptures = toObject(namedCaptures);
                    symbols = SUBSTITUTION_SYMBOLS;
                }
                return $replace.call(replacement, symbols, function (match, ch) {
                    var capture;
                    switch (ch.charAt(0)) {
                        case '$': return '$';
                        case '&': return matched;
                        case '`': return str.slice(0, position);
                        case "'": return str.slice(tailPos);
                        case '<':
                            capture = namedCaptures[ch.slice(1, -1)];
                            break;
                        default: // \d\d?
                            var n = +ch;
                            if (n === 0) return match;
                            if (n > m) {
                                var f = floor(n / 10);
                                if (f === 0) return match;
                                if (f <= m) return captures[f - 1] === undefined ? ch.charAt(1) : captures[f - 1] + ch.charAt(1);
                                return match;
                            }
                            capture = captures[n - 1];
                    }
                    return capture === undefined ? '' : capture;
                });
            }
        });

    },{"./_advance-string-index":3,"./_an-object":4,"./_fix-re-wks":19,"./_regexp-exec-abstract":55,"./_to-integer":67,"./_to-length":69,"./_to-object":70}],86:[function(require,module,exports){
        'use strict';

        var isRegExp = require('./_is-regexp');
        var anObject = require('./_an-object');
        var speciesConstructor = require('./_species-constructor');
        var advanceStringIndex = require('./_advance-string-index');
        var toLength = require('./_to-length');
        var callRegExpExec = require('./_regexp-exec-abstract');
        var regexpExec = require('./_regexp-exec');
        var fails = require('./_fails');
        var $min = Math.min;
        var $push = [].push;
        var $SPLIT = 'split';
        var LENGTH = 'length';
        var LAST_INDEX = 'lastIndex';
        var MAX_UINT32 = 0xffffffff;

// babel-minify transpiles RegExp('x', 'y') -> /x/y and it causes SyntaxError
        var SUPPORTS_Y = !fails(function () { RegExp(MAX_UINT32, 'y'); });

// @@split logic
        require('./_fix-re-wks')('split', 2, function (defined, SPLIT, $split, maybeCallNative) {
            var internalSplit;
            if (
                'abbc'[$SPLIT](/(b)*/)[1] == 'c' ||
                'test'[$SPLIT](/(?:)/, -1)[LENGTH] != 4 ||
                'ab'[$SPLIT](/(?:ab)*/)[LENGTH] != 2 ||
                '.'[$SPLIT](/(.?)(.?)/)[LENGTH] != 4 ||
                '.'[$SPLIT](/()()/)[LENGTH] > 1 ||
                ''[$SPLIT](/.?/)[LENGTH]
            ) {
                // based on es5-shim implementation, need to rework it
                internalSplit = function (separator, limit) {
                    var string = String(this);
                    if (separator === undefined && limit === 0) return [];
                    // If `separator` is not a regex, use native split
                    if (!isRegExp(separator)) return $split.call(string, separator, limit);
                    var output = [];
                    var flags = (separator.ignoreCase ? 'i' : '') +
                        (separator.multiline ? 'm' : '') +
                        (separator.unicode ? 'u' : '') +
                        (separator.sticky ? 'y' : '');
                    var lastLastIndex = 0;
                    var splitLimit = limit === undefined ? MAX_UINT32 : limit >>> 0;
                    // Make `global` and avoid `lastIndex` issues by working with a copy
                    var separatorCopy = new RegExp(separator.source, flags + 'g');
                    var match, lastIndex, lastLength;
                    while (match = regexpExec.call(separatorCopy, string)) {
                        lastIndex = separatorCopy[LAST_INDEX];
                        if (lastIndex > lastLastIndex) {
                            output.push(string.slice(lastLastIndex, match.index));
                            if (match[LENGTH] > 1 && match.index < string[LENGTH]) $push.apply(output, match.slice(1));
                            lastLength = match[0][LENGTH];
                            lastLastIndex = lastIndex;
                            if (output[LENGTH] >= splitLimit) break;
                        }
                        if (separatorCopy[LAST_INDEX] === match.index) separatorCopy[LAST_INDEX]++; // Avoid an infinite loop
                    }
                    if (lastLastIndex === string[LENGTH]) {
                        if (lastLength || !separatorCopy.test('')) output.push('');
                    } else output.push(string.slice(lastLastIndex));
                    return output[LENGTH] > splitLimit ? output.slice(0, splitLimit) : output;
                };
                // Chakra, V8
            } else if ('0'[$SPLIT](undefined, 0)[LENGTH]) {
                internalSplit = function (separator, limit) {
                    return separator === undefined && limit === 0 ? [] : $split.call(this, separator, limit);
                };
            } else {
                internalSplit = $split;
            }

            return [
                // `String.prototype.split` method
                // https://tc39.github.io/ecma262/#sec-string.prototype.split
                function split(separator, limit) {
                    var O = defined(this);
                    var splitter = separator == undefined ? undefined : separator[SPLIT];
                    return splitter !== undefined
                        ? splitter.call(separator, O, limit)
                        : internalSplit.call(String(O), separator, limit);
                },
                // `RegExp.prototype[@@split]` method
                // https://tc39.github.io/ecma262/#sec-regexp.prototype-@@split
                //
                // NOTE: This cannot be properly polyfilled in engines that don't support
                // the 'y' flag.
                function (regexp, limit) {
                    var res = maybeCallNative(internalSplit, regexp, this, limit, internalSplit !== $split);
                    if (res.done) return res.value;

                    var rx = anObject(regexp);
                    var S = String(this);
                    var C = speciesConstructor(rx, RegExp);

                    var unicodeMatching = rx.unicode;
                    var flags = (rx.ignoreCase ? 'i' : '') +
                        (rx.multiline ? 'm' : '') +
                        (rx.unicode ? 'u' : '') +
                        (SUPPORTS_Y ? 'y' : 'g');

                    // ^(? + rx + ) is needed, in combination with some S slicing, to
                    // simulate the 'y' flag.
                    var splitter = new C(SUPPORTS_Y ? rx : '^(?:' + rx.source + ')', flags);
                    var lim = limit === undefined ? MAX_UINT32 : limit >>> 0;
                    if (lim === 0) return [];
                    if (S.length === 0) return callRegExpExec(splitter, S) === null ? [S] : [];
                    var p = 0;
                    var q = 0;
                    var A = [];
                    while (q < S.length) {
                        splitter.lastIndex = SUPPORTS_Y ? q : 0;
                        var z = callRegExpExec(splitter, SUPPORTS_Y ? S : S.slice(q));
                        var e;
                        if (
                            z === null ||
                            (e = $min(toLength(splitter.lastIndex + (SUPPORTS_Y ? 0 : q)), S.length)) === p
                        ) {
                            q = advanceStringIndex(S, q, unicodeMatching);
                        } else {
                            A.push(S.slice(p, q));
                            if (A.length === lim) return A;
                            for (var i = 1; i <= z.length - 1; i++) {
                                A.push(z[i]);
                                if (A.length === lim) return A;
                            }
                            q = p = e;
                        }
                    }
                    A.push(S.slice(p));
                    return A;
                }
            ];
        });

    },{"./_advance-string-index":3,"./_an-object":4,"./_fails":18,"./_fix-re-wks":19,"./_is-regexp":32,"./_regexp-exec":56,"./_regexp-exec-abstract":55,"./_species-constructor":62,"./_to-length":69}],87:[function(require,module,exports){
        'use strict';
        require('./es6.regexp.flags');
        var anObject = require('./_an-object');
        var $flags = require('./_flags');
        var DESCRIPTORS = require('./_descriptors');
        var TO_STRING = 'toString';
        var $toString = /./[TO_STRING];

        var define = function (fn) {
            require('./_redefine')(RegExp.prototype, TO_STRING, fn, true);
        };

// 21.2.5.14 RegExp.prototype.toString()
        if (require('./_fails')(function () { return $toString.call({ source: 'a', flags: 'b' }) != '/a/b'; })) {
            define(function toString() {
                var R = anObject(this);
                return '/'.concat(R.source, '/',
                    'flags' in R ? R.flags : !DESCRIPTORS && R instanceof RegExp ? $flags.call(R) : undefined);
            });
// FF44- RegExp#toString has a wrong name
        } else if ($toString.name != TO_STRING) {
            define(function toString() {
                return $toString.call(this);
            });
        }

    },{"./_an-object":4,"./_descriptors":12,"./_fails":18,"./_flags":20,"./_redefine":54,"./es6.regexp.flags":83}],88:[function(require,module,exports){
// 21.1.3.7 String.prototype.includes(searchString, position = 0)
        'use strict';
        var $export = require('./_export');
        var context = require('./_string-context');
        var INCLUDES = 'includes';

        $export($export.P + $export.F * require('./_fails-is-regexp')(INCLUDES), 'String', {
            includes: function includes(searchString /* , position = 0 */) {
                return !!~context(this, searchString, INCLUDES)
                    .indexOf(searchString, arguments.length > 1 ? arguments[1] : undefined);
            }
        });

    },{"./_export":16,"./_fails-is-regexp":17,"./_string-context":64}],89:[function(require,module,exports){
        'use strict';
        var $at = require('./_string-at')(true);

// 21.1.3.27 String.prototype[@@iterator]()
        require('./_iter-define')(String, 'String', function (iterated) {
            this._t = String(iterated); // target
            this._i = 0;                // next index
// 21.1.5.2.1 %StringIteratorPrototype%.next()
        }, function () {
            var O = this._t;
            var index = this._i;
            var point;
            if (index >= O.length) return { value: undefined, done: true };
            point = $at(O, index);
            this._i += point.length;
            return { value: point, done: false };
        });

    },{"./_iter-define":35,"./_string-at":63}],90:[function(require,module,exports){
        'use strict';
// B.2.3.10 String.prototype.link(url)
        require('./_string-html')('link', function (createHTML) {
            return function link(url) {
                return createHTML(this, 'a', 'href', url);
            };
        });

    },{"./_string-html":65}],91:[function(require,module,exports){
        'use strict';
// ECMAScript 6 symbols shim
        var global = require('./_global');
        var has = require('./_has');
        var DESCRIPTORS = require('./_descriptors');
        var $export = require('./_export');
        var redefine = require('./_redefine');
        var META = require('./_meta').KEY;
        var $fails = require('./_fails');
        var shared = require('./_shared');
        var setToStringTag = require('./_set-to-string-tag');
        var uid = require('./_uid');
        var wks = require('./_wks');
        var wksExt = require('./_wks-ext');
        var wksDefine = require('./_wks-define');
        var enumKeys = require('./_enum-keys');
        var isArray = require('./_is-array');
        var anObject = require('./_an-object');
        var isObject = require('./_is-object');
        var toObject = require('./_to-object');
        var toIObject = require('./_to-iobject');
        var toPrimitive = require('./_to-primitive');
        var createDesc = require('./_property-desc');
        var _create = require('./_object-create');
        var gOPNExt = require('./_object-gopn-ext');
        var $GOPD = require('./_object-gopd');
        var $GOPS = require('./_object-gops');
        var $DP = require('./_object-dp');
        var $keys = require('./_object-keys');
        var gOPD = $GOPD.f;
        var dP = $DP.f;
        var gOPN = gOPNExt.f;
        var $Symbol = global.Symbol;
        var $JSON = global.JSON;
        var _stringify = $JSON && $JSON.stringify;
        var PROTOTYPE = 'prototype';
        var HIDDEN = wks('_hidden');
        var TO_PRIMITIVE = wks('toPrimitive');
        var isEnum = {}.propertyIsEnumerable;
        var SymbolRegistry = shared('symbol-registry');
        var AllSymbols = shared('symbols');
        var OPSymbols = shared('op-symbols');
        var ObjectProto = Object[PROTOTYPE];
        var USE_NATIVE = typeof $Symbol == 'function' && !!$GOPS.f;
        var QObject = global.QObject;
// Don't use setters in Qt Script, https://github.com/zloirock/core-js/issues/173
        var setter = !QObject || !QObject[PROTOTYPE] || !QObject[PROTOTYPE].findChild;

// fallback for old Android, https://code.google.com/p/v8/issues/detail?id=687
        var setSymbolDesc = DESCRIPTORS && $fails(function () {
            return _create(dP({}, 'a', {
                get: function () { return dP(this, 'a', { value: 7 }).a; }
            })).a != 7;
        }) ? function (it, key, D) {
            var protoDesc = gOPD(ObjectProto, key);
            if (protoDesc) delete ObjectProto[key];
            dP(it, key, D);
            if (protoDesc && it !== ObjectProto) dP(ObjectProto, key, protoDesc);
        } : dP;

        var wrap = function (tag) {
            var sym = AllSymbols[tag] = _create($Symbol[PROTOTYPE]);
            sym._k = tag;
            return sym;
        };

        var isSymbol = USE_NATIVE && typeof $Symbol.iterator == 'symbol' ? function (it) {
            return typeof it == 'symbol';
        } : function (it) {
            return it instanceof $Symbol;
        };

        var $defineProperty = function defineProperty(it, key, D) {
            if (it === ObjectProto) $defineProperty(OPSymbols, key, D);
            anObject(it);
            key = toPrimitive(key, true);
            anObject(D);
            if (has(AllSymbols, key)) {
                if (!D.enumerable) {
                    if (!has(it, HIDDEN)) dP(it, HIDDEN, createDesc(1, {}));
                    it[HIDDEN][key] = true;
                } else {
                    if (has(it, HIDDEN) && it[HIDDEN][key]) it[HIDDEN][key] = false;
                    D = _create(D, { enumerable: createDesc(0, false) });
                } return setSymbolDesc(it, key, D);
            } return dP(it, key, D);
        };
        var $defineProperties = function defineProperties(it, P) {
            anObject(it);
            var keys = enumKeys(P = toIObject(P));
            var i = 0;
            var l = keys.length;
            var key;
            while (l > i) $defineProperty(it, key = keys[i++], P[key]);
            return it;
        };
        var $create = function create(it, P) {
            return P === undefined ? _create(it) : $defineProperties(_create(it), P);
        };
        var $propertyIsEnumerable = function propertyIsEnumerable(key) {
            var E = isEnum.call(this, key = toPrimitive(key, true));
            if (this === ObjectProto && has(AllSymbols, key) && !has(OPSymbols, key)) return false;
            return E || !has(this, key) || !has(AllSymbols, key) || has(this, HIDDEN) && this[HIDDEN][key] ? E : true;
        };
        var $getOwnPropertyDescriptor = function getOwnPropertyDescriptor(it, key) {
            it = toIObject(it);
            key = toPrimitive(key, true);
            if (it === ObjectProto && has(AllSymbols, key) && !has(OPSymbols, key)) return;
            var D = gOPD(it, key);
            if (D && has(AllSymbols, key) && !(has(it, HIDDEN) && it[HIDDEN][key])) D.enumerable = true;
            return D;
        };
        var $getOwnPropertyNames = function getOwnPropertyNames(it) {
            var names = gOPN(toIObject(it));
            var result = [];
            var i = 0;
            var key;
            while (names.length > i) {
                if (!has(AllSymbols, key = names[i++]) && key != HIDDEN && key != META) result.push(key);
            } return result;
        };
        var $getOwnPropertySymbols = function getOwnPropertySymbols(it) {
            var IS_OP = it === ObjectProto;
            var names = gOPN(IS_OP ? OPSymbols : toIObject(it));
            var result = [];
            var i = 0;
            var key;
            while (names.length > i) {
                if (has(AllSymbols, key = names[i++]) && (IS_OP ? has(ObjectProto, key) : true)) result.push(AllSymbols[key]);
            } return result;
        };

// 19.4.1.1 Symbol([description])
        if (!USE_NATIVE) {
            $Symbol = function Symbol() {
                if (this instanceof $Symbol) throw TypeError('Symbol is not a constructor!');
                var tag = uid(arguments.length > 0 ? arguments[0] : undefined);
                var $set = function (value) {
                    if (this === ObjectProto) $set.call(OPSymbols, value);
                    if (has(this, HIDDEN) && has(this[HIDDEN], tag)) this[HIDDEN][tag] = false;
                    setSymbolDesc(this, tag, createDesc(1, value));
                };
                if (DESCRIPTORS && setter) setSymbolDesc(ObjectProto, tag, { configurable: true, set: $set });
                return wrap(tag);
            };
            redefine($Symbol[PROTOTYPE], 'toString', function toString() {
                return this._k;
            });

            $GOPD.f = $getOwnPropertyDescriptor;
            $DP.f = $defineProperty;
            require('./_object-gopn').f = gOPNExt.f = $getOwnPropertyNames;
            require('./_object-pie').f = $propertyIsEnumerable;
            $GOPS.f = $getOwnPropertySymbols;

            if (DESCRIPTORS && !require('./_library')) {
                redefine(ObjectProto, 'propertyIsEnumerable', $propertyIsEnumerable, true);
            }

            wksExt.f = function (name) {
                return wrap(wks(name));
            };
        }

        $export($export.G + $export.W + $export.F * !USE_NATIVE, { Symbol: $Symbol });

        for (var es6Symbols = (
            // 19.4.2.2, 19.4.2.3, 19.4.2.4, 19.4.2.6, 19.4.2.8, 19.4.2.9, 19.4.2.10, 19.4.2.11, 19.4.2.12, 19.4.2.13, 19.4.2.14
            'hasInstance,isConcatSpreadable,iterator,match,replace,search,species,split,toPrimitive,toStringTag,unscopables'
        ).split(','), j = 0; es6Symbols.length > j;)wks(es6Symbols[j++]);

        for (var wellKnownSymbols = $keys(wks.store), k = 0; wellKnownSymbols.length > k;) wksDefine(wellKnownSymbols[k++]);

        $export($export.S + $export.F * !USE_NATIVE, 'Symbol', {
            // 19.4.2.1 Symbol.for(key)
            'for': function (key) {
                return has(SymbolRegistry, key += '')
                    ? SymbolRegistry[key]
                    : SymbolRegistry[key] = $Symbol(key);
            },
            // 19.4.2.5 Symbol.keyFor(sym)
            keyFor: function keyFor(sym) {
                if (!isSymbol(sym)) throw TypeError(sym + ' is not a symbol!');
                for (var key in SymbolRegistry) if (SymbolRegistry[key] === sym) return key;
            },
            useSetter: function () { setter = true; },
            useSimple: function () { setter = false; }
        });

        $export($export.S + $export.F * !USE_NATIVE, 'Object', {
            // 19.1.2.2 Object.create(O [, Properties])
            create: $create,
            // 19.1.2.4 Object.defineProperty(O, P, Attributes)
            defineProperty: $defineProperty,
            // 19.1.2.3 Object.defineProperties(O, Properties)
            defineProperties: $defineProperties,
            // 19.1.2.6 Object.getOwnPropertyDescriptor(O, P)
            getOwnPropertyDescriptor: $getOwnPropertyDescriptor,
            // 19.1.2.7 Object.getOwnPropertyNames(O)
            getOwnPropertyNames: $getOwnPropertyNames,
            // 19.1.2.8 Object.getOwnPropertySymbols(O)
            getOwnPropertySymbols: $getOwnPropertySymbols
        });

// Chrome 38 and 39 `Object.getOwnPropertySymbols` fails on primitives
// https://bugs.chromium.org/p/v8/issues/detail?id=3443
        var FAILS_ON_PRIMITIVES = $fails(function () { $GOPS.f(1); });

        $export($export.S + $export.F * FAILS_ON_PRIMITIVES, 'Object', {
            getOwnPropertySymbols: function getOwnPropertySymbols(it) {
                return $GOPS.f(toObject(it));
            }
        });

// 24.3.2 JSON.stringify(value [, replacer [, space]])
        $JSON && $export($export.S + $export.F * (!USE_NATIVE || $fails(function () {
            var S = $Symbol();
            // MS Edge converts symbol values to JSON as {}
            // WebKit converts symbol values to JSON as null
            // V8 throws on boxed symbols
            return _stringify([S]) != '[null]' || _stringify({ a: S }) != '{}' || _stringify(Object(S)) != '{}';
        })), 'JSON', {
            stringify: function stringify(it) {
                var args = [it];
                var i = 1;
                var replacer, $replacer;
                while (arguments.length > i) args.push(arguments[i++]);
                $replacer = replacer = args[1];
                if (!isObject(replacer) && it === undefined || isSymbol(it)) return; // IE8 returns string on undefined
                if (!isArray(replacer)) replacer = function (key, value) {
                    if (typeof $replacer == 'function') value = $replacer.call(this, key, value);
                    if (!isSymbol(value)) return value;
                };
                args[1] = replacer;
                return _stringify.apply($JSON, args);
            }
        });

// 19.4.3.4 Symbol.prototype[@@toPrimitive](hint)
        $Symbol[PROTOTYPE][TO_PRIMITIVE] || require('./_hide')($Symbol[PROTOTYPE], TO_PRIMITIVE, $Symbol[PROTOTYPE].valueOf);
// 19.4.3.5 Symbol.prototype[@@toStringTag]
        setToStringTag($Symbol, 'Symbol');
// 20.2.1.9 Math[@@toStringTag]
        setToStringTag(Math, 'Math', true);
// 24.3.3 JSON[@@toStringTag]
        setToStringTag(global.JSON, 'JSON', true);

    },{"./_an-object":4,"./_descriptors":12,"./_enum-keys":15,"./_export":16,"./_fails":18,"./_global":22,"./_has":23,"./_hide":24,"./_is-array":30,"./_is-object":31,"./_library":39,"./_meta":40,"./_object-create":41,"./_object-dp":42,"./_object-gopd":44,"./_object-gopn":46,"./_object-gopn-ext":45,"./_object-gops":47,"./_object-keys":50,"./_object-pie":51,"./_property-desc":53,"./_redefine":54,"./_set-to-string-tag":59,"./_shared":61,"./_to-iobject":68,"./_to-object":70,"./_to-primitive":71,"./_uid":72,"./_wks":75,"./_wks-define":73,"./_wks-ext":74}],92:[function(require,module,exports){
        'use strict';
// https://github.com/tc39/Array.prototype.includes
        var $export = require('./_export');
        var $includes = require('./_array-includes')(true);

        $export($export.P, 'Array', {
            includes: function includes(el /* , fromIndex = 0 */) {
                return $includes(this, el, arguments.length > 1 ? arguments[1] : undefined);
            }
        });

        require('./_add-to-unscopables')('includes');

    },{"./_add-to-unscopables":2,"./_array-includes":5,"./_export":16}],93:[function(require,module,exports){
        require('./_wks-define')('asyncIterator');

    },{"./_wks-define":73}],94:[function(require,module,exports){
        var $iterators = require('./es6.array.iterator');
        var getKeys = require('./_object-keys');
        var redefine = require('./_redefine');
        var global = require('./_global');
        var hide = require('./_hide');
        var Iterators = require('./_iterators');
        var wks = require('./_wks');
        var ITERATOR = wks('iterator');
        var TO_STRING_TAG = wks('toStringTag');
        var ArrayValues = Iterators.Array;

        var DOMIterables = {
            CSSRuleList: true, // TODO: Not spec compliant, should be false.
            CSSStyleDeclaration: false,
            CSSValueList: false,
            ClientRectList: false,
            DOMRectList: false,
            DOMStringList: false,
            DOMTokenList: true,
            DataTransferItemList: false,
            FileList: false,
            HTMLAllCollection: false,
            HTMLCollection: false,
            HTMLFormElement: false,
            HTMLSelectElement: false,
            MediaList: true, // TODO: Not spec compliant, should be false.
            MimeTypeArray: false,
            NamedNodeMap: false,
            NodeList: true,
            PaintRequestList: false,
            Plugin: false,
            PluginArray: false,
            SVGLengthList: false,
            SVGNumberList: false,
            SVGPathSegList: false,
            SVGPointList: false,
            SVGStringList: false,
            SVGTransformList: false,
            SourceBufferList: false,
            StyleSheetList: true, // TODO: Not spec compliant, should be false.
            TextTrackCueList: false,
            TextTrackList: false,
            TouchList: false
        };

        for (var collections = getKeys(DOMIterables), i = 0; i < collections.length; i++) {
            var NAME = collections[i];
            var explicit = DOMIterables[NAME];
            var Collection = global[NAME];
            var proto = Collection && Collection.prototype;
            var key;
            if (proto) {
                if (!proto[ITERATOR]) hide(proto, ITERATOR, ArrayValues);
                if (!proto[TO_STRING_TAG]) hide(proto, TO_STRING_TAG, NAME);
                Iterators[NAME] = ArrayValues;
                if (explicit) for (key in $iterators) if (!proto[key]) redefine(proto, key, $iterators[key], true);
            }
        }

    },{"./_global":22,"./_hide":24,"./_iterators":38,"./_object-keys":50,"./_redefine":54,"./_wks":75,"./es6.array.iterator":78}],95:[function(require,module,exports){
        "use strict";

        function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

        function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

        function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

        var _require = require('./protocol'),
            Parser = _require.Parser,
            PROTOCOL_6 = _require.PROTOCOL_6,
            PROTOCOL_7 = _require.PROTOCOL_7;

        var VERSION = "3.2.2";

        var Connector = /*#__PURE__*/function () {
            function Connector(options, WebSocket, Timer, handlers) {
                var _this = this;

                _classCallCheck(this, Connector);

                this.options = options;
                this.WebSocket = WebSocket;
                this.Timer = Timer;
                this.handlers = handlers;
                var path = this.options.path ? "".concat(this.options.path) : 'livereload';
                this._uri = "ws".concat(this.options.https ? 's' : '', "://").concat(this.options.host, ":").concat(this.options.port, "/").concat(path);
                this._nextDelay = this.options.mindelay;
                this._connectionDesired = false;
                this.protocol = 0;
                this.protocolParser = new Parser({
                    connected: function connected(protocol) {
                        _this.protocol = protocol;

                        _this._handshakeTimeout.stop();

                        _this._nextDelay = _this.options.mindelay;
                        _this._disconnectionReason = 'broken';
                        return _this.handlers.connected(_this.protocol);
                    },
                    error: function error(e) {
                        _this.handlers.error(e);

                        return _this._closeOnError();
                    },
                    message: function message(_message) {
                        return _this.handlers.message(_message);
                    }
                });
                this._handshakeTimeout = new this.Timer(function () {
                    if (!_this._isSocketConnected()) {
                        return;
                    }

                    _this._disconnectionReason = 'handshake-timeout';
                    return _this.socket.close();
                });
                this._reconnectTimer = new this.Timer(function () {
                    if (!_this._connectionDesired) {
                        // shouldn't hit this, but just in case
                        return;
                    }

                    return _this.connect();
                });
                this.connect();
            }

            _createClass(Connector, [{
                key: "_isSocketConnected",
                value: function _isSocketConnected() {
                    return this.socket && this.socket.readyState === this.WebSocket.OPEN;
                }
            }, {
                key: "connect",
                value: function connect() {
                    var _this2 = this;

                    this._connectionDesired = true;

                    if (this._isSocketConnected()) {
                        return;
                    } // prepare for a new connection


                    this._reconnectTimer.stop();

                    this._disconnectionReason = 'cannot-connect';
                    this.protocolParser.reset();
                    this.handlers.connecting();
                    this.socket = new this.WebSocket(this._uri);

                    this.socket.onopen = function (e) {
                        return _this2._onopen(e);
                    };

                    this.socket.onclose = function (e) {
                        return _this2._onclose(e);
                    };

                    this.socket.onmessage = function (e) {
                        return _this2._onmessage(e);
                    };

                    this.socket.onerror = function (e) {
                        return _this2._onerror(e);
                    };
                }
            }, {
                key: "disconnect",
                value: function disconnect() {
                    this._connectionDesired = false;

                    this._reconnectTimer.stop(); // in case it was running


                    if (!this._isSocketConnected()) {
                        return;
                    }

                    this._disconnectionReason = 'manual';
                    return this.socket.close();
                }
            }, {
                key: "_scheduleReconnection",
                value: function _scheduleReconnection() {
                    if (!this._connectionDesired) {
                        // don't reconnect after manual disconnection
                        return;
                    }

                    if (!this._reconnectTimer.running) {
                        this._reconnectTimer.start(this._nextDelay);

                        this._nextDelay = Math.min(this.options.maxdelay, this._nextDelay * 2);
                    }
                }
            }, {
                key: "sendCommand",
                value: function sendCommand(command) {
                    if (!this.protocol) {
                        return;
                    }

                    return this._sendCommand(command);
                }
            }, {
                key: "_sendCommand",
                value: function _sendCommand(command) {
                    return this.socket.send(JSON.stringify(command));
                }
            }, {
                key: "_closeOnError",
                value: function _closeOnError() {
                    this._handshakeTimeout.stop();

                    this._disconnectionReason = 'error';
                    return this.socket.close();
                }
            }, {
                key: "_onopen",
                value: function _onopen(e) {
                    this.handlers.socketConnected();
                    this._disconnectionReason = 'handshake-failed'; // start handshake

                    var hello = {
                        command: 'hello',
                        protocols: [PROTOCOL_6, PROTOCOL_7]
                    };
                    hello.ver = VERSION;

                    if (this.options.ext) {
                        hello.ext = this.options.ext;
                    }

                    if (this.options.extver) {
                        hello.extver = this.options.extver;
                    }

                    if (this.options.snipver) {
                        hello.snipver = this.options.snipver;
                    }

                    this._sendCommand(hello);

                    return this._handshakeTimeout.start(this.options.handshake_timeout);
                }
            }, {
                key: "_onclose",
                value: function _onclose(e) {
                    this.protocol = 0;
                    this.handlers.disconnected(this._disconnectionReason, this._nextDelay);
                    return this._scheduleReconnection();
                }
            }, {
                key: "_onerror",
                value: function _onerror(e) {}
            }, {
                key: "_onmessage",
                value: function _onmessage(e) {
                    return this.protocolParser.process(e.data);
                }
            }]);

            return Connector;
        }();

        ;
        exports.Connector = Connector;

    },{"./protocol":100}],96:[function(require,module,exports){
        "use strict";

        var CustomEvents = {
            bind: function bind(element, eventName, handler) {
                if (element.addEventListener) {
                    return element.addEventListener(eventName, handler, false);
                } else if (element.attachEvent) {
                    element[eventName] = 1;
                    return element.attachEvent('onpropertychange', function (event) {
                        if (event.propertyName === eventName) {
                            return handler();
                        }
                    });
                } else {
                    throw new Error("Attempt to attach custom event ".concat(eventName, " to something which isn't a DOMElement"));
                }
            },
            fire: function fire(element, eventName) {
                if (element.addEventListener) {
                    var event = document.createEvent('HTMLEvents');
                    event.initEvent(eventName, true, true);
                    return document.dispatchEvent(event);
                } else if (element.attachEvent) {
                    if (element[eventName]) {
                        return element[eventName]++;
                    }
                } else {
                    throw new Error("Attempt to fire custom event ".concat(eventName, " on something which isn't a DOMElement"));
                }
            }
        };
        exports.bind = CustomEvents.bind;
        exports.fire = CustomEvents.fire;

    },{}],97:[function(require,module,exports){
        "use strict";

        require("core-js/modules/es6.string.iterator");

        require("core-js/modules/es6.array.from");

        require("core-js/modules/es6.regexp.match");

        function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

        function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

        function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

        var LessPlugin = /*#__PURE__*/function () {
            function LessPlugin(window, host) {
                _classCallCheck(this, LessPlugin);

                this.window = window;
                this.host = host;
            }

            _createClass(LessPlugin, [{
                key: "reload",
                value: function reload(path, options) {
                    if (this.window.less && this.window.less.refresh) {
                        if (path.match(/\.less$/i)) {
                            return this.reloadLess(path);
                        }

                        if (options.originalPath.match(/\.less$/i)) {
                            return this.reloadLess(options.originalPath);
                        }
                    }

                    return false;
                }
            }, {
                key: "reloadLess",
                value: function reloadLess(path) {
                    var link;

                    var links = function () {
                        var result = [];

                        for (var _i = 0, _Array$from = Array.from(document.getElementsByTagName('link')); _i < _Array$from.length; _i++) {
                            link = _Array$from[_i];

                            if (link.href && link.rel.match(/^stylesheet\/less$/i) || link.rel.match(/stylesheet/i) && link.type.match(/^text\/(x-)?less$/i)) {
                                result.push(link);
                            }
                        }

                        return result;
                    }();

                    if (links.length === 0) {
                        return false;
                    }

                    for (var _i2 = 0, _Array$from2 = Array.from(links); _i2 < _Array$from2.length; _i2++) {
                        link = _Array$from2[_i2];
                        link.href = this.host.generateCacheBustUrl(link.href);
                    }

                    this.host.console.log('LiveReload is asking LESS to recompile all stylesheets');
                    this.window.less.refresh(true);
                    return true;
                }
            }, {
                key: "analyze",
                value: function analyze() {
                    return {
                        disable: !!(this.window.less && this.window.less.refresh)
                    };
                }
            }]);

            return LessPlugin;
        }();

        ;
        LessPlugin.identifier = 'less';
        LessPlugin.version = '1.0';
        module.exports = LessPlugin;

    },{"core-js/modules/es6.array.from":77,"core-js/modules/es6.regexp.match":84,"core-js/modules/es6.string.iterator":89}],98:[function(require,module,exports){
        "use strict";

        require("core-js/modules/es7.symbol.async-iterator");

        require("core-js/modules/es6.symbol");

        require("core-js/modules/web.dom.iterable");

        require("core-js/modules/es6.array.iterator");

        require("core-js/modules/es6.object.to-string");

        require("core-js/modules/es6.object.keys");

        require("core-js/modules/es6.regexp.match");

        function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

        function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

        function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

        /* global alert */
        var _require = require('./connector'),
            Connector = _require.Connector;

        var _require2 = require('./timer'),
            Timer = _require2.Timer;

        var _require3 = require('./options'),
            Options = _require3.Options;

        var _require4 = require('./reloader'),
            Reloader = _require4.Reloader;

        var _require5 = require('./protocol'),
            ProtocolError = _require5.ProtocolError;

        var LiveReload = /*#__PURE__*/function () {
            function LiveReload(window) {
                var _this = this;

                _classCallCheck(this, LiveReload);

                this.window = window;
                this.listeners = {};
                this.plugins = [];
                this.pluginIdentifiers = {}; // i can haz console?

                this.console = this.window.console && this.window.console.log && this.window.console.error ? this.window.location.href.match(/LR-verbose/) ? this.window.console : {
                    log: function log() {},
                    error: this.window.console.error.bind(this.window.console)
                } : {
                    log: function log() {},
                    error: function error() {}
                }; // i can haz sockets?

                if (!(this.WebSocket = this.window.WebSocket || this.window.MozWebSocket)) {
                    this.console.error('LiveReload disabled because the browser does not seem to support web sockets');
                    return;
                } // i can haz options?


                if ('LiveReloadOptions' in window) {
                    this.options = new Options();

                    for (var _i = 0, _Object$keys = Object.keys(window.LiveReloadOptions || {}); _i < _Object$keys.length; _i++) {
                        var k = _Object$keys[_i];
                        var v = window.LiveReloadOptions[k];
                        this.options.set(k, v);
                    }
                } else {
                    this.options = Options.extract(this.window.document);

                    if (!this.options) {
                        this.console.error('LiveReload disabled because it could not find its own <SCRIPT> tag');
                        return;
                    }
                } // i can haz reloader?


                this.reloader = new Reloader(this.window, this.console, Timer); // i can haz connection?

                this.connector = new Connector(this.options, this.WebSocket, Timer, {
                    connecting: function connecting() {},
                    socketConnected: function socketConnected() {},
                    connected: function connected(protocol) {
                        if (typeof _this.listeners.connect === 'function') {
                            _this.listeners.connect();
                        }

                        _this.log("LiveReload is connected to ".concat(_this.options.host, ":").concat(_this.options.port, " (protocol v").concat(protocol, ")."));

                        return _this.analyze();
                    },
                    error: function error(e) {
                        if (e instanceof ProtocolError) {
                            if (typeof console !== 'undefined' && console !== null) {
                                return console.log("".concat(e.message, "."));
                            }
                        } else {
                            if (typeof console !== 'undefined' && console !== null) {
                                return console.log("LiveReload internal error: ".concat(e.message));
                            }
                        }
                    },
                    disconnected: function disconnected(reason, nextDelay) {
                        if (typeof _this.listeners.disconnect === 'function') {
                            _this.listeners.disconnect();
                        }

                        switch (reason) {
                            case 'cannot-connect':
                                return _this.log("LiveReload cannot connect to ".concat(_this.options.host, ":").concat(_this.options.port, ", will retry in ").concat(nextDelay, " sec."));

                            case 'broken':
                                return _this.log("LiveReload disconnected from ".concat(_this.options.host, ":").concat(_this.options.port, ", reconnecting in ").concat(nextDelay, " sec."));

                            case 'handshake-timeout':
                                return _this.log("LiveReload cannot connect to ".concat(_this.options.host, ":").concat(_this.options.port, " (handshake timeout), will retry in ").concat(nextDelay, " sec."));

                            case 'handshake-failed':
                                return _this.log("LiveReload cannot connect to ".concat(_this.options.host, ":").concat(_this.options.port, " (handshake failed), will retry in ").concat(nextDelay, " sec."));

                            case 'manual': // nop

                            case 'error': // nop

                            default:
                                return _this.log("LiveReload disconnected from ".concat(_this.options.host, ":").concat(_this.options.port, " (").concat(reason, "), reconnecting in ").concat(nextDelay, " sec."));
                        }
                    },
                    message: function message(_message) {
                        switch (_message.command) {
                            case 'reload':
                                return _this.performReload(_message);

                            case 'alert':
                                return _this.performAlert(_message);
                        }
                    }
                });
                this.initialized = true;
            }

            _createClass(LiveReload, [{
                key: "on",
                value: function on(eventName, handler) {
                    this.listeners[eventName] = handler;
                }
            }, {
                key: "log",
                value: function log(message) {
                    return this.console.log("".concat(message));
                }
            }, {
                key: "performReload",
                value: function performReload(message) {
                    this.log("LiveReload received reload request: ".concat(JSON.stringify(message, null, 2)));
                    return this.reloader.reload(message.path, {
                        liveCSS: message.liveCSS != null ? message.liveCSS : true,
                        liveImg: message.liveImg != null ? message.liveImg : true,
                        reloadMissingCSS: message.reloadMissingCSS != null ? message.reloadMissingCSS : true,
                        originalPath: message.originalPath || '',
                        overrideURL: message.overrideURL || '',
                        serverURL: "http://".concat(this.options.host, ":").concat(this.options.port),
                        pluginOrder: this.options.pluginOrder
                    });
                }
            }, {
                key: "performAlert",
                value: function performAlert(message) {
                    return alert(message.message);
                }
            }, {
                key: "shutDown",
                value: function shutDown() {
                    if (!this.initialized) {
                        return;
                    }

                    this.connector.disconnect();
                    this.log('LiveReload disconnected.');
                    return typeof this.listeners.shutdown === 'function' ? this.listeners.shutdown() : undefined;
                }
            }, {
                key: "hasPlugin",
                value: function hasPlugin(identifier) {
                    return !!this.pluginIdentifiers[identifier];
                }
            }, {
                key: "addPlugin",
                value: function addPlugin(PluginClass) {
                    var _this2 = this;

                    if (!this.initialized) {
                        return;
                    }

                    if (this.hasPlugin(PluginClass.identifier)) {
                        return;
                    }

                    this.pluginIdentifiers[PluginClass.identifier] = true;
                    var plugin = new PluginClass(this.window, {
                        // expose internal objects for those who know what they're doing
                        // (note that these are private APIs and subject to change at any time!)
                        _livereload: this,
                        _reloader: this.reloader,
                        _connector: this.connector,
                        // official API
                        console: this.console,
                        Timer: Timer,
                        generateCacheBustUrl: function generateCacheBustUrl(url) {
                            return _this2.reloader.generateCacheBustUrl(url);
                        }
                    }); // API that PluginClass can/must provide:
                    //
                    // string PluginClass.identifier
                    //   -- required, globally-unique name of this plugin
                    //
                    // string PluginClass.version
                    //   -- required, plugin version number (format %d.%d or %d.%d.%d)
                    //
                    // plugin = new PluginClass(window, officialLiveReloadAPI)
                    //   -- required, plugin constructor
                    //
                    // bool plugin.reload(string path, { bool liveCSS, bool liveImg })
                    //   -- optional, attemp to reload the given path, return true if handled
                    //
                    // object plugin.analyze()
                    //   -- optional, returns plugin-specific information about the current document (to send to the connected server)
                    //      (LiveReload 2 server currently only defines 'disable' key in this object; return {disable:true} to disable server-side
                    //       compilation of a matching plugin's files)

                    this.plugins.push(plugin);
                    this.reloader.addPlugin(plugin);
                }
            }, {
                key: "analyze",
                value: function analyze() {
                    if (!this.initialized) {
                        return;
                    }

                    if (!(this.connector.protocol >= 7)) {
                        return;
                    }

                    var pluginsData = {};
                    var _iteratorNormalCompletion = true;
                    var _didIteratorError = false;
                    var _iteratorError = undefined;

                    try {
                        for (var _iterator = this.plugins[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
                            var plugin = _step.value;
                            var pluginData = (typeof plugin.analyze === 'function' ? plugin.analyze() : undefined) || {};
                            pluginsData[plugin.constructor.identifier] = pluginData;
                            pluginData.version = plugin.constructor.version;
                        }
                    } catch (err) {
                        _didIteratorError = true;
                        _iteratorError = err;
                    } finally {
                        try {
                            if (!_iteratorNormalCompletion && _iterator.return != null) {
                                _iterator.return();
                            }
                        } finally {
                            if (_didIteratorError) {
                                throw _iteratorError;
                            }
                        }
                    }

                    this.connector.sendCommand({
                        command: 'info',
                        plugins: pluginsData,
                        url: this.window.location.href
                    });
                }
            }]);

            return LiveReload;
        }();

        ;
        exports.LiveReload = LiveReload;

    },{"./connector":95,"./options":99,"./protocol":100,"./reloader":101,"./timer":103,"core-js/modules/es6.array.iterator":78,"core-js/modules/es6.object.keys":79,"core-js/modules/es6.object.to-string":80,"core-js/modules/es6.regexp.match":84,"core-js/modules/es6.symbol":91,"core-js/modules/es7.symbol.async-iterator":93,"core-js/modules/web.dom.iterable":94}],99:[function(require,module,exports){
        "use strict";

        require("core-js/modules/es6.regexp.to-string");

        require("core-js/modules/es6.object.to-string");

        require("core-js/modules/es6.regexp.replace");

        require("core-js/modules/es7.symbol.async-iterator");

        require("core-js/modules/es6.symbol");

        require("core-js/modules/web.dom.iterable");

        require("core-js/modules/es6.regexp.match");

        require("core-js/modules/es6.string.iterator");

        require("core-js/modules/es6.array.from");

        require("core-js/modules/es6.regexp.split");

        function _slicedToArray(arr, i) { return _arrayWithHoles(arr) || _iterableToArrayLimit(arr, i) || _nonIterableRest(); }

        function _nonIterableRest() { throw new TypeError("Invalid attempt to destructure non-iterable instance"); }

        function _iterableToArrayLimit(arr, i) { if (!(Symbol.iterator in Object(arr) || Object.prototype.toString.call(arr) === "[object Arguments]")) { return; } var _arr = []; var _n = true; var _d = false; var _e = undefined; try { for (var _i = arr[Symbol.iterator](), _s; !(_n = (_s = _i.next()).done); _n = true) { _arr.push(_s.value); if (i && _arr.length === i) break; } } catch (err) { _d = true; _e = err; } finally { try { if (!_n && _i["return"] != null) _i["return"](); } finally { if (_d) throw _e; } } return _arr; }

        function _arrayWithHoles(arr) { if (Array.isArray(arr)) return arr; }

        function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

        function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

        function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

        var Options = /*#__PURE__*/function () {
            function Options() {
                _classCallCheck(this, Options);

                this.https = false;
                this.host = null;
                this.port = 35729;
                this.snipver = null;
                this.ext = null;
                this.extver = null;
                this.mindelay = 1000;
                this.maxdelay = 60000;
                this.handshake_timeout = 5000;
                var pluginOrder = [];
                Object.defineProperty(this, 'pluginOrder', {
                    get: function get() {
                        return pluginOrder;
                    },
                    set: function set(v) {
                        pluginOrder.push.apply(pluginOrder, v.split(/[,;]/));
                    }
                });
            }

            _createClass(Options, [{
                key: "set",
                value: function set(name, value) {
                    if (typeof value === 'undefined') {
                        return;
                    }

                    if (!isNaN(+value)) {
                        value = +value;
                    }

                    this[name] = value;
                }
            }]);

            return Options;
        }();

        Options.extract = function (document) {
            for (var _i = 0, _Array$from = Array.from(document.getElementsByTagName('script')); _i < _Array$from.length; _i++) {
                var element = _Array$from[_i];
                var m;
                var mm;
                var src = element.src;
                var srcAttr = element.getAttribute('src');
                var lrUrlRegexp = /^([^:]+:\/\/([^/:]+)(?::(\d+))?\/|\/\/|\/)?([^/].*\/)?z?livereload\.js(?:\?(.*))?$/; //                   ^proto:// ^host       ^port     ^//  ^/   ^folder

                if ((m = src.match(lrUrlRegexp)) && (mm = srcAttr.match(lrUrlRegexp))) {
                    var _m = m,
                        _m2 = _slicedToArray(_m, 6),
                        host = _m2[2],
                        port = _m2[3],
                        params = _m2[5];

                    var _mm = mm,
                        _mm2 = _slicedToArray(_mm, 4),
                        portFromAttr = _mm2[3];

                    var options = new Options();
                    options.https = element.src.indexOf('https') === 0;
                    options.host = host;
                    options.port = port ? parseInt(port, 10) : portFromAttr ? parseInt(portFromAttr, 10) : options.port;

                    if (params) {
                        var _iteratorNormalCompletion = true;
                        var _didIteratorError = false;
                        var _iteratorError = undefined;

                        try {
                            for (var _iterator = params.split('&')[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
                                var pair = _step.value;
                                var keyAndValue;

                                if ((keyAndValue = pair.split('=')).length > 1) {
                                    options.set(keyAndValue[0].replace(/-/g, '_'), keyAndValue.slice(1).join('='));
                                }
                            }
                        } catch (err) {
                            _didIteratorError = true;
                            _iteratorError = err;
                        } finally {
                            try {
                                if (!_iteratorNormalCompletion && _iterator.return != null) {
                                    _iterator.return();
                                }
                            } finally {
                                if (_didIteratorError) {
                                    throw _iteratorError;
                                }
                            }
                        }
                    }

                    return options;
                }
            }

            return null;
        };

        exports.Options = Options;

    },{"core-js/modules/es6.array.from":77,"core-js/modules/es6.object.to-string":80,"core-js/modules/es6.regexp.match":84,"core-js/modules/es6.regexp.replace":85,"core-js/modules/es6.regexp.split":86,"core-js/modules/es6.regexp.to-string":87,"core-js/modules/es6.string.iterator":89,"core-js/modules/es6.symbol":91,"core-js/modules/es7.symbol.async-iterator":93,"core-js/modules/web.dom.iterable":94}],100:[function(require,module,exports){
        "use strict";

        require("core-js/modules/es6.regexp.to-string");

        require("core-js/modules/es6.object.to-string");

        require("core-js/modules/es7.symbol.async-iterator");

        require("core-js/modules/es6.symbol");

        require("core-js/modules/web.dom.iterable");

        require("core-js/modules/es6.string.iterator");

        require("core-js/modules/es6.array.from");

        require("core-js/modules/es7.array.includes");

        require("core-js/modules/es6.string.includes");

        require("core-js/modules/es6.regexp.constructor");

        require("core-js/modules/es6.regexp.match");

        function _slicedToArray(arr, i) { return _arrayWithHoles(arr) || _iterableToArrayLimit(arr, i) || _nonIterableRest(); }

        function _nonIterableRest() { throw new TypeError("Invalid attempt to destructure non-iterable instance"); }

        function _iterableToArrayLimit(arr, i) { if (!(Symbol.iterator in Object(arr) || Object.prototype.toString.call(arr) === "[object Arguments]")) { return; } var _arr = []; var _n = true; var _d = false; var _e = undefined; try { for (var _i = arr[Symbol.iterator](), _s; !(_n = (_s = _i.next()).done); _n = true) { _arr.push(_s.value); if (i && _arr.length === i) break; } } catch (err) { _d = true; _e = err; } finally { try { if (!_n && _i["return"] != null) _i["return"](); } finally { if (_d) throw _e; } } return _arr; }

        function _arrayWithHoles(arr) { if (Array.isArray(arr)) return arr; }

        function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

        function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

        function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

        var PROTOCOL_6, PROTOCOL_7;
        exports.PROTOCOL_6 = PROTOCOL_6 = 'http://livereload.com/protocols/official-6';
        exports.PROTOCOL_7 = PROTOCOL_7 = 'http://livereload.com/protocols/official-7';

        var ProtocolError = function ProtocolError(reason, data) {
            _classCallCheck(this, ProtocolError);

            this.message = "LiveReload protocol error (".concat(reason, ") after receiving data: \"").concat(data, "\".");
        };

        ;

        var Parser = /*#__PURE__*/function () {
            function Parser(handlers) {
                _classCallCheck(this, Parser);

                this.handlers = handlers;
                this.reset();
            }

            _createClass(Parser, [{
                key: "reset",
                value: function reset() {
                    this.protocol = null;
                }
            }, {
                key: "process",
                value: function process(data) {
                    try {
                        var message;

                        if (!this.protocol) {
                            if (data.match(new RegExp('^!!ver:([\\d.]+)$'))) {
                                this.protocol = 6;
                            } else if (message = this._parseMessage(data, ['hello'])) {
                                if (!message.protocols.length) {
                                    throw new ProtocolError('no protocols specified in handshake message');
                                } else if (Array.from(message.protocols).includes(PROTOCOL_7)) {
                                    this.protocol = 7;
                                } else if (Array.from(message.protocols).includes(PROTOCOL_6)) {
                                    this.protocol = 6;
                                } else {
                                    throw new ProtocolError('no supported protocols found');
                                }
                            }

                            return this.handlers.connected(this.protocol);
                        } else if (this.protocol === 6) {
                            message = JSON.parse(data);

                            if (!message.length) {
                                throw new ProtocolError('protocol 6 messages must be arrays');
                            }

                            var _Array$from = Array.from(message),
                                _Array$from2 = _slicedToArray(_Array$from, 2),
                                command = _Array$from2[0],
                                options = _Array$from2[1];

                            if (command !== 'refresh') {
                                throw new ProtocolError('unknown protocol 6 command');
                            }

                            return this.handlers.message({
                                command: 'reload',
                                path: options.path,
                                liveCSS: options.apply_css_live != null ? options.apply_css_live : true
                            });
                        } else {
                            message = this._parseMessage(data, ['reload', 'alert']);
                            return this.handlers.message(message);
                        }
                    } catch (e) {
                        if (e instanceof ProtocolError) {
                            return this.handlers.error(e);
                        } else {
                            throw e;
                        }
                    }
                }
            }, {
                key: "_parseMessage",
                value: function _parseMessage(data, validCommands) {
                    var message;

                    try {
                        message = JSON.parse(data);
                    } catch (e) {
                        throw new ProtocolError('unparsable JSON', data);
                    }

                    if (!message.command) {
                        throw new ProtocolError('missing "command" key', data);
                    }

                    if (!validCommands.includes(message.command)) {
                        throw new ProtocolError("invalid command '".concat(message.command, "', only valid commands are: ").concat(validCommands.join(', '), ")"), data);
                    }

                    return message;
                }
            }]);

            return Parser;
        }();

        ;
        exports.ProtocolError = ProtocolError;
        exports.Parser = Parser;

    },{"core-js/modules/es6.array.from":77,"core-js/modules/es6.object.to-string":80,"core-js/modules/es6.regexp.constructor":81,"core-js/modules/es6.regexp.match":84,"core-js/modules/es6.regexp.to-string":87,"core-js/modules/es6.string.includes":88,"core-js/modules/es6.string.iterator":89,"core-js/modules/es6.symbol":91,"core-js/modules/es7.array.includes":92,"core-js/modules/es7.symbol.async-iterator":93,"core-js/modules/web.dom.iterable":94}],101:[function(require,module,exports){
        "use strict";

        require("core-js/modules/es6.string.link");

        require("core-js/modules/es6.string.iterator");

        require("core-js/modules/es6.array.from");

        require("core-js/modules/es6.regexp.match");

        require("core-js/modules/es6.regexp.split");

        require("core-js/modules/es7.symbol.async-iterator");

        require("core-js/modules/es6.symbol");

        require("core-js/modules/web.dom.iterable");

        require("core-js/modules/es6.regexp.constructor");

        require("core-js/modules/es6.regexp.replace");

        function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

        function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

        function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

        /* global CSSRule */
        var splitUrl = function splitUrl(url) {
            var hash, index, params;

            if ((index = url.indexOf('#')) >= 0) {
                hash = url.slice(index);
                url = url.slice(0, index);
            } else {
                hash = '';
            } // http://your.domain.com/path/to/combo/??file1.css,file2,css


            var comboSign = url.indexOf('??');

            if (comboSign >= 0) {
                if (comboSign + 1 !== url.lastIndexOf('?')) {
                    index = url.lastIndexOf('?');
                }
            } else {
                index = url.indexOf('?');
            }

            if (index >= 0) {
                params = url.slice(index);
                url = url.slice(0, index);
            } else {
                params = '';
            }

            return {
                url: url,
                params: params,
                hash: hash
            };
        };

        var pathFromUrl = function pathFromUrl(url) {
            if (!url) {
                return '';
            }

            var path;

            var _splitUrl = splitUrl(url);

            url = _splitUrl.url;

            if (url.indexOf('file://') === 0) {
                path = url.replace(new RegExp('^file://(localhost)?'), '');
            } else {
                //                        http  :   // hostname  :8080  /
                path = url.replace(new RegExp('^([^:]+:)?//([^:/]+)(:\\d*)?/'), '/');
            } // decodeURI has special handling of stuff like semicolons, so use decodeURIComponent


            return decodeURIComponent(path);
        };

        var pickBestMatch = function pickBestMatch(path, objects, pathFunc) {
            var score;
            var bestMatch = {
                score: 0
            };
            var _iteratorNormalCompletion = true;
            var _didIteratorError = false;
            var _iteratorError = undefined;

            try {
                for (var _iterator = objects[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
                    var object = _step.value;
                    score = numberOfMatchingSegments(path, pathFunc(object));

                    if (score > bestMatch.score) {
                        bestMatch = {
                            object: object,
                            score: score
                        };
                    }
                }
            } catch (err) {
                _didIteratorError = true;
                _iteratorError = err;
            } finally {
                try {
                    if (!_iteratorNormalCompletion && _iterator.return != null) {
                        _iterator.return();
                    }
                } finally {
                    if (_didIteratorError) {
                        throw _iteratorError;
                    }
                }
            }

            if (bestMatch.score === 0) {
                return null;
            }

            return bestMatch;
        };

        var numberOfMatchingSegments = function numberOfMatchingSegments(path1, path2) {
            // get rid of leading slashes and normalize to lower case
            path1 = path1.replace(/^\/+/, '').toLowerCase();
            path2 = path2.replace(/^\/+/, '').toLowerCase();

            if (path1 === path2) {
                return 10000;
            }

            var comps1 = path1.split('/').reverse();
            var comps2 = path2.split('/').reverse();
            var len = Math.min(comps1.length, comps2.length);
            var eqCount = 0;

            while (eqCount < len && comps1[eqCount] === comps2[eqCount]) {
                ++eqCount;
            }

            return eqCount;
        };

        var pathsMatch = function pathsMatch(path1, path2) {
            return numberOfMatchingSegments(path1, path2) > 0;
        };

        var IMAGE_STYLES = [{
            selector: 'background',
            styleNames: ['backgroundImage']
        }, {
            selector: 'border',
            styleNames: ['borderImage', 'webkitBorderImage', 'MozBorderImage']
        }];

        var Reloader = /*#__PURE__*/function () {
            function Reloader(window, console, Timer) {
                _classCallCheck(this, Reloader);

                this.window = window;
                this.console = console;
                this.Timer = Timer;
                this.document = this.window.document;
                this.importCacheWaitPeriod = 200;
                this.plugins = [];
            }

            _createClass(Reloader, [{
                key: "addPlugin",
                value: function addPlugin(plugin) {
                    return this.plugins.push(plugin);
                }
            }, {
                key: "analyze",
                value: function analyze(callback) {}
            }, {
                key: "reload",
                value: function reload(path, options) {
                    this.options = options; // avoid passing it through all the funcs

                    if (!this.options.stylesheetReloadTimeout) {
                        this.options.stylesheetReloadTimeout = 15000;
                    }

                    if (this.options.pluginOrder && this.options.pluginOrder.length) {
                        this.runPluginsByOrder(path, options);
                        return;
                    }

                    for (var _i = 0, _Array$from = Array.from(this.plugins); _i < _Array$from.length; _i++) {
                        var plugin = _Array$from[_i];

                        if (plugin.reload && plugin.reload(path, options)) {
                            return;
                        }
                    }

                    if (options.liveCSS && path.match(/\.css(?:\.map)?$/i)) {
                        if (this.reloadStylesheet(path)) {
                            return;
                        }
                    }

                    if (options.liveImg && path.match(/\.(jpe?g|png|gif)$/i)) {
                        this.reloadImages(path);
                        return;
                    }

                    if (options.isChromeExtension) {
                        this.reloadChromeExtension();
                        return;
                    }

                    return this.reloadPage();
                }
            }, {
                key: "runPluginsByOrder",
                value: function runPluginsByOrder(path, options) {
                    var _this = this;

                    options.pluginOrder.some(function (pluginId) {
                        if (pluginId === 'css') {
                            if (options.liveCSS && path.match(/\.css(?:\.map)?$/i)) {
                                if (_this.reloadStylesheet(path)) {
                                    return true;
                                }
                            }
                        }

                        if (pluginId === 'img') {
                            if (options.liveImg && path.match(/\.(jpe?g|png|gif)$/i)) {
                                _this.reloadImages(path);

                                return true;
                            }
                        }

                        if (pluginId === 'extension') {
                            if (options.isChromeExtension) {
                                _this.reloadChromeExtension();

                                return true;
                            }
                        }

                        if (pluginId === 'others') {
                            _this.reloadPage();

                            return true;
                        }

                        if (pluginId === 'external') {
                            return _this.plugins.some(function (plugin) {
                                if (plugin.reload && plugin.reload(path, options)) {
                                    return true;
                                }
                            });
                        }

                        return _this.plugins.filter(function (plugin) {
                            return plugin.constructor.identifier === pluginId;
                        }).some(function (plugin) {
                            if (plugin.reload && plugin.reload(path, options)) {
                                return true;
                            }
                        });
                    });
                }
            }, {
                key: "reloadPage",
                value: function reloadPage() {
                    return this.window.document.location.reload();
                }
            }, {
                key: "reloadChromeExtension",
                value: function reloadChromeExtension() {
                    return this.window.chrome.runtime.reload();
                }
            }, {
                key: "reloadImages",
                value: function reloadImages(path) {
                    var _this2 = this;

                    var img;
                    var expando = this.generateUniqueString();

                    for (var _i2 = 0, _Array$from2 = Array.from(this.document.images); _i2 < _Array$from2.length; _i2++) {
                        img = _Array$from2[_i2];

                        if (pathsMatch(path, pathFromUrl(img.src))) {
                            img.src = this.generateCacheBustUrl(img.src, expando);
                        }
                    }

                    if (this.document.querySelectorAll) {
                        var _iteratorNormalCompletion2 = true;
                        var _didIteratorError2 = false;
                        var _iteratorError2 = undefined;

                        try {
                            for (var _iterator2 = IMAGE_STYLES[Symbol.iterator](), _step2; !(_iteratorNormalCompletion2 = (_step2 = _iterator2.next()).done); _iteratorNormalCompletion2 = true) {
                                var _step2$value = _step2.value,
                                    selector = _step2$value.selector,
                                    styleNames = _step2$value.styleNames;

                                for (var _i3 = 0, _Array$from3 = Array.from(this.document.querySelectorAll("[style*=".concat(selector, "]"))); _i3 < _Array$from3.length; _i3++) {
                                    img = _Array$from3[_i3];
                                    this.reloadStyleImages(img.style, styleNames, path, expando);
                                }
                            }
                        } catch (err) {
                            _didIteratorError2 = true;
                            _iteratorError2 = err;
                        } finally {
                            try {
                                if (!_iteratorNormalCompletion2 && _iterator2.return != null) {
                                    _iterator2.return();
                                }
                            } finally {
                                if (_didIteratorError2) {
                                    throw _iteratorError2;
                                }
                            }
                        }
                    }

                    if (this.document.styleSheets) {
                        return Array.from(this.document.styleSheets).map(function (styleSheet) {
                            return _this2.reloadStylesheetImages(styleSheet, path, expando);
                        });
                    }
                }
            }, {
                key: "reloadStylesheetImages",
                value: function reloadStylesheetImages(styleSheet, path, expando) {
                    var rules;

                    try {
                        rules = (styleSheet || {}).cssRules;
                    } catch (e) {}

                    if (!rules) {
                        return;
                    }

                    for (var _i4 = 0, _Array$from4 = Array.from(rules); _i4 < _Array$from4.length; _i4++) {
                        var rule = _Array$from4[_i4];

                        switch (rule.type) {
                            case CSSRule.IMPORT_RULE:
                                this.reloadStylesheetImages(rule.styleSheet, path, expando);
                                break;

                            case CSSRule.STYLE_RULE:
                                var _iteratorNormalCompletion3 = true;
                                var _didIteratorError3 = false;
                                var _iteratorError3 = undefined;

                                try {
                                    for (var _iterator3 = IMAGE_STYLES[Symbol.iterator](), _step3; !(_iteratorNormalCompletion3 = (_step3 = _iterator3.next()).done); _iteratorNormalCompletion3 = true) {
                                        var styleNames = _step3.value.styleNames;
                                        this.reloadStyleImages(rule.style, styleNames, path, expando);
                                    }
                                } catch (err) {
                                    _didIteratorError3 = true;
                                    _iteratorError3 = err;
                                } finally {
                                    try {
                                        if (!_iteratorNormalCompletion3 && _iterator3.return != null) {
                                            _iterator3.return();
                                        }
                                    } finally {
                                        if (_didIteratorError3) {
                                            throw _iteratorError3;
                                        }
                                    }
                                }

                                break;

                            case CSSRule.MEDIA_RULE:
                                this.reloadStylesheetImages(rule, path, expando);
                                break;
                        }
                    }
                }
            }, {
                key: "reloadStyleImages",
                value: function reloadStyleImages(style, styleNames, path, expando) {
                    var _this3 = this;

                    var _iteratorNormalCompletion4 = true;
                    var _didIteratorError4 = false;
                    var _iteratorError4 = undefined;

                    try {
                        for (var _iterator4 = styleNames[Symbol.iterator](), _step4; !(_iteratorNormalCompletion4 = (_step4 = _iterator4.next()).done); _iteratorNormalCompletion4 = true) {
                            var styleName = _step4.value;
                            var value = style[styleName];

                            if (typeof value === 'string') {
                                var newValue = value.replace(new RegExp('\\burl\\s*\\(([^)]*)\\)'), function (match, src) {
                                    if (pathsMatch(path, pathFromUrl(src))) {
                                        return "url(".concat(_this3.generateCacheBustUrl(src, expando), ")");
                                    } else {
                                        return match;
                                    }
                                });

                                if (newValue !== value) {
                                    style[styleName] = newValue;
                                }
                            }
                        }
                    } catch (err) {
                        _didIteratorError4 = true;
                        _iteratorError4 = err;
                    } finally {
                        try {
                            if (!_iteratorNormalCompletion4 && _iterator4.return != null) {
                                _iterator4.return();
                            }
                        } finally {
                            if (_didIteratorError4) {
                                throw _iteratorError4;
                            }
                        }
                    }
                }
            }, {
                key: "reloadStylesheet",
                value: function reloadStylesheet(path) {
                    var _this4 = this;

                    // has to be a real array, because DOMNodeList will be modified
                    var style;
                    var link;

                    var links = function () {
                        var result = [];

                        for (var _i5 = 0, _Array$from5 = Array.from(_this4.document.getElementsByTagName('link')); _i5 < _Array$from5.length; _i5++) {
                            link = _Array$from5[_i5];

                            if (link.rel.match(/^stylesheet$/i) && !link.__LiveReload_pendingRemoval) {
                                result.push(link);
                            }
                        }

                        return result;
                    }(); // find all imported stylesheets


                    var imported = [];

                    for (var _i6 = 0, _Array$from6 = Array.from(this.document.getElementsByTagName('style')); _i6 < _Array$from6.length; _i6++) {
                        style = _Array$from6[_i6];

                        if (style.sheet) {
                            this.collectImportedStylesheets(style, style.sheet, imported);
                        }
                    }

                    for (var _i7 = 0, _Array$from7 = Array.from(links); _i7 < _Array$from7.length; _i7++) {
                        link = _Array$from7[_i7];
                        this.collectImportedStylesheets(link, link.sheet, imported);
                    } // handle prefixfree


                    if (this.window.StyleFix && this.document.querySelectorAll) {
                        for (var _i8 = 0, _Array$from8 = Array.from(this.document.querySelectorAll('style[data-href]')); _i8 < _Array$from8.length; _i8++) {
                            style = _Array$from8[_i8];
                            links.push(style);
                        }
                    }

                    this.console.log("LiveReload found ".concat(links.length, " LINKed stylesheets, ").concat(imported.length, " @imported stylesheets"));
                    var match = pickBestMatch(path, links.concat(imported), function (link) {
                        return pathFromUrl(_this4.linkHref(link));
                    });

                    if (match) {
                        if (match.object.rule) {
                            this.console.log("LiveReload is reloading imported stylesheet: ".concat(match.object.href));
                            this.reattachImportedRule(match.object);
                        } else {
                            this.console.log("LiveReload is reloading stylesheet: ".concat(this.linkHref(match.object)));
                            this.reattachStylesheetLink(match.object);
                        }
                    } else {
                        if (this.options.reloadMissingCSS) {
                            this.console.log("LiveReload will reload all stylesheets because path '".concat(path, "' did not match any specific one. To disable this behavior, set 'options.reloadMissingCSS' to 'false'."));

                            for (var _i9 = 0, _Array$from9 = Array.from(links); _i9 < _Array$from9.length; _i9++) {
                                link = _Array$from9[_i9];
                                this.reattachStylesheetLink(link);
                            }
                        } else {
                            this.console.log("LiveReload will not reload path '".concat(path, "' because the stylesheet was not found on the page and 'options.reloadMissingCSS' was set to 'false'."));
                        }
                    }

                    return true;
                }
            }, {
                key: "collectImportedStylesheets",
                value: function collectImportedStylesheets(link, styleSheet, result) {
                    // in WebKit, styleSheet.cssRules is null for inaccessible stylesheets;
                    // Firefox/Opera may throw exceptions
                    var rules;

                    try {
                        rules = (styleSheet || {}).cssRules;
                    } catch (e) {}

                    if (rules && rules.length) {
                        for (var index = 0; index < rules.length; index++) {
                            var rule = rules[index];

                            switch (rule.type) {
                                case CSSRule.CHARSET_RULE:
                                    continue;
                                // do nothing

                                case CSSRule.IMPORT_RULE:
                                    result.push({
                                        link: link,
                                        rule: rule,
                                        index: index,
                                        href: rule.href
                                    });
                                    this.collectImportedStylesheets(link, rule.styleSheet, result);
                                    break;

                                default:
                                    break;
                                // import rules can only be preceded by charset rules
                            }
                        }
                    }
                }
            }, {
                key: "waitUntilCssLoads",
                value: function waitUntilCssLoads(clone, func) {
                    var _this5 = this;

                    var callbackExecuted = false;

                    var executeCallback = function executeCallback() {
                        if (callbackExecuted) {
                            return;
                        }

                        callbackExecuted = true;
                        return func();
                    }; // supported by Chrome 19+, Safari 5.2+, Firefox 9+, Opera 9+, IE6+
                    // http://www.zachleat.com/web/load-css-dynamically/
                    // http://pieisgood.org/test/script-link-events/


                    clone.onload = function () {
                        _this5.console.log('LiveReload: the new stylesheet has finished loading');

                        _this5.knownToSupportCssOnLoad = true;
                        return executeCallback();
                    };

                    if (!this.knownToSupportCssOnLoad) {
                        // polling
                        var _poll;

                        (_poll = function poll() {
                            if (clone.sheet) {
                                _this5.console.log('LiveReload is polling until the new CSS finishes loading...');

                                return executeCallback();
                            } else {
                                return _this5.Timer.start(50, _poll);
                            }
                        })();
                    } // fail safe


                    return this.Timer.start(this.options.stylesheetReloadTimeout, executeCallback);
                }
            }, {
                key: "linkHref",
                value: function linkHref(link) {
                    // prefixfree uses data-href when it turns LINK into STYLE
                    return link.href || link.getAttribute && link.getAttribute('data-href');
                }
            }, {
                key: "reattachStylesheetLink",
                value: function reattachStylesheetLink(link) {
                    var _this6 = this;

                    // ignore LINKs that will be removed by LR soon
                    var clone;

                    if (link.__LiveReload_pendingRemoval) {
                        return;
                    }

                    link.__LiveReload_pendingRemoval = true;

                    if (link.tagName === 'STYLE') {
                        // prefixfree
                        clone = this.document.createElement('link');
                        clone.rel = 'stylesheet';
                        clone.media = link.media;
                        clone.disabled = link.disabled;
                    } else {
                        clone = link.cloneNode(false);
                    }

                    clone.href = this.generateCacheBustUrl(this.linkHref(link)); // insert the new LINK before the old one

                    var parent = link.parentNode;

                    if (parent.lastChild === link) {
                        parent.appendChild(clone);
                    } else {
                        parent.insertBefore(clone, link.nextSibling);
                    }

                    return this.waitUntilCssLoads(clone, function () {
                        var additionalWaitingTime;

                        if (/AppleWebKit/.test(navigator.userAgent)) {
                            additionalWaitingTime = 5;
                        } else {
                            additionalWaitingTime = 200;
                        }

                        return _this6.Timer.start(additionalWaitingTime, function () {
                            if (!link.parentNode) {
                                return;
                            }

                            link.parentNode.removeChild(link);
                            clone.onreadystatechange = null;
                            return _this6.window.StyleFix ? _this6.window.StyleFix.link(clone) : undefined;
                        });
                    }); // prefixfree
                }
            }, {
                key: "reattachImportedRule",
                value: function reattachImportedRule(_ref) {
                    var _this7 = this;

                    var rule = _ref.rule,
                        index = _ref.index,
                        link = _ref.link;
                    var parent = rule.parentStyleSheet;
                    var href = this.generateCacheBustUrl(rule.href);
                    var media = rule.media.length ? [].join.call(rule.media, ', ') : '';
                    var newRule = "@import url(\"".concat(href, "\") ").concat(media, ";"); // used to detect if reattachImportedRule has been called again on the same rule

                    rule.__LiveReload_newHref = href; // WORKAROUND FOR WEBKIT BUG: WebKit resets all styles if we add @import'ed
                    // stylesheet that hasn't been cached yet. Workaround is to pre-cache the
                    // stylesheet by temporarily adding it as a LINK tag.

                    var tempLink = this.document.createElement('link');
                    tempLink.rel = 'stylesheet';
                    tempLink.href = href;
                    tempLink.__LiveReload_pendingRemoval = true; // exclude from path matching

                    if (link.parentNode) {
                        link.parentNode.insertBefore(tempLink, link);
                    } // wait for it to load


                    return this.Timer.start(this.importCacheWaitPeriod, function () {
                        if (tempLink.parentNode) {
                            tempLink.parentNode.removeChild(tempLink);
                        } // if another reattachImportedRule call is in progress, abandon this one


                        if (rule.__LiveReload_newHref !== href) {
                            return;
                        }

                        parent.insertRule(newRule, index);
                        parent.deleteRule(index + 1); // save the new rule, so that we can detect another reattachImportedRule call

                        rule = parent.cssRules[index];
                        rule.__LiveReload_newHref = href; // repeat again for good measure

                        return _this7.Timer.start(_this7.importCacheWaitPeriod, function () {
                            // if another reattachImportedRule call is in progress, abandon this one
                            if (rule.__LiveReload_newHref !== href) {
                                return;
                            }

                            parent.insertRule(newRule, index);
                            return parent.deleteRule(index + 1);
                        });
                    });
                }
            }, {
                key: "generateUniqueString",
                value: function generateUniqueString() {
                    return "livereload=".concat(Date.now());
                }
            }, {
                key: "generateCacheBustUrl",
                value: function generateCacheBustUrl(url, expando) {
                    var hash, oldParams;

                    if (!expando) {
                        expando = this.generateUniqueString();
                    }

                    var _splitUrl2 = splitUrl(url);

                    url = _splitUrl2.url;
                    hash = _splitUrl2.hash;
                    oldParams = _splitUrl2.params;

                    if (this.options.overrideURL) {
                        if (url.indexOf(this.options.serverURL) < 0) {
                            var originalUrl = url;
                            url = this.options.serverURL + this.options.overrideURL + '?url=' + encodeURIComponent(url);
                            this.console.log("LiveReload is overriding source URL ".concat(originalUrl, " with ").concat(url));
                        }
                    }

                    var params = oldParams.replace(/(\?|&)livereload=(\d+)/, function (match, sep) {
                        return "".concat(sep).concat(expando);
                    });

                    if (params === oldParams) {
                        if (oldParams.length === 0) {
                            params = "?".concat(expando);
                        } else {
                            params = "".concat(oldParams, "&").concat(expando);
                        }
                    }

                    return url + params + hash;
                }
            }]);

            return Reloader;
        }();

        ;
        exports.Reloader = Reloader;

    },{"core-js/modules/es6.array.from":77,"core-js/modules/es6.regexp.constructor":81,"core-js/modules/es6.regexp.match":84,"core-js/modules/es6.regexp.replace":85,"core-js/modules/es6.regexp.split":86,"core-js/modules/es6.string.iterator":89,"core-js/modules/es6.string.link":90,"core-js/modules/es6.symbol":91,"core-js/modules/es7.symbol.async-iterator":93,"core-js/modules/web.dom.iterable":94}],102:[function(require,module,exports){
        "use strict";

        require("core-js/modules/es6.regexp.match");

        var CustomEvents = require('./customevents');

        var LiveReload = window.LiveReload = new (require('./livereload').LiveReload)(window);

        for (var k in window) {
            if (k.match(/^LiveReloadPlugin/)) {
                LiveReload.addPlugin(window[k]);
            }
        }

        LiveReload.addPlugin(require('./less'));
        LiveReload.on('shutdown', function () {
            return delete window.LiveReload;
        });
        LiveReload.on('connect', function () {
            return CustomEvents.fire(document, 'LiveReloadConnect');
        });
        LiveReload.on('disconnect', function () {
            return CustomEvents.fire(document, 'LiveReloadDisconnect');
        });
        CustomEvents.bind(document, 'LiveReloadShutDown', function () {
            return LiveReload.shutDown();
        });

    },{"./customevents":96,"./less":97,"./livereload":98,"core-js/modules/es6.regexp.match":84}],103:[function(require,module,exports){
        "use strict";

        function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

        function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

        function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

        var Timer = /*#__PURE__*/function () {
            function Timer(func) {
                var _this = this;

                _classCallCheck(this, Timer);

                this.func = func;
                this.running = false;
                this.id = null;

                this._handler = function () {
                    _this.running = false;
                    _this.id = null;
                    return _this.func();
                };
            }

            _createClass(Timer, [{
                key: "start",
                value: function start(timeout) {
                    if (this.running) {
                        clearTimeout(this.id);
                    }

                    this.id = setTimeout(this._handler, timeout);
                    this.running = true;
                }
            }, {
                key: "stop",
                value: function stop() {
                    if (this.running) {
                        clearTimeout(this.id);
                        this.running = false;
                        this.id = null;
                    }
                }
            }]);

            return Timer;
        }();

        ;

        Timer.start = function (timeout, func) {
            return setTimeout(func, timeout);
        };

        exports.Timer = Timer;

    },{}]},{},[102]);