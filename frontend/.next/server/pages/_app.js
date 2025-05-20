/*
 * ATTENTION: An "eval-source-map" devtool has been used.
 * This devtool is neither made for production nor for readable output files.
 * It uses "eval()" calls to create a separate source file with attached SourceMaps in the browser devtools.
 * If you are trying to read the output file, select a different devtool (https://webpack.js.org/configuration/devtool/)
 * or disable the default devtool with "devtool: false".
 * If you are looking for production-ready output files, see mode: "production" (https://webpack.js.org/configuration/mode/).
 */
(() => {
var exports = {};
exports.id = "pages/_app";
exports.ids = ["pages/_app"];
exports.modules = {

/***/ "./pages/_app.jsx":
/*!************************!*\
  !*** ./pages/_app.jsx ***!
  \************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   \"default\": () => (/* binding */ Layout)\n/* harmony export */ });\n/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react/jsx-dev-runtime */ \"react/jsx-dev-runtime\");\n/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__);\n/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! react */ \"react\");\n/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_1__);\n/* harmony import */ var _styles_globals_css__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../styles/globals.css */ \"./styles/globals.css\");\n/* harmony import */ var _styles_globals_css__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(_styles_globals_css__WEBPACK_IMPORTED_MODULE_2__);\n/* harmony import */ var _styles_styles_css__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../styles/styles.css */ \"./styles/styles.css\");\n/* harmony import */ var _styles_styles_css__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/__webpack_require__.n(_styles_styles_css__WEBPACK_IMPORTED_MODULE_3__);\n\n\n\n\nfunction Layout({ Component, pageProps }) {\n    (0,react__WEBPACK_IMPORTED_MODULE_1__.useEffect)({\n        \"Layout.useEffect\": ()=>{\n            setInterval({\n                \"Layout.useEffect\": async ()=>{\n                    const req = await fetch(\"http://localhost:8080/api/auth/update_tokens\", {\n                        method: \"POST\",\n                        headers: {\n                            \"Content-Type\": \"application/json;charset=utf-8\"\n                        },\n                        body: JSON.stringify({\n                            refreshToken: localStorage.getItem(\"refreshToken\")\n                        })\n                    });\n                    if (req.ok) {\n                        const res = await req.json();\n                        localStorage.setItem(\"accessToken\", res.accessToken);\n                        localStorage.setItem(\"refreshToken\", res.refreshToken);\n                        document.cookie = `accessToken = ${res.accessToken}`;\n                        console.log(\"success\");\n                    } else {\n                        console.log(\"error\");\n                    }\n                }\n            }[\"Layout.useEffect\"], 60000);\n        }\n    }[\"Layout.useEffect\"], []);\n    return /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n        className: \"text-slate-900 bg-[#F3E9DC] dark:bg-coffee min-h-[100vh]\",\n        children: /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(Component, {\n            ...pageProps\n        }, void 0, false, {\n            fileName: \"C:\\\\Users\\\\mihai\\\\OneDrive\\\\Desktop\\\\Программирование\\\\Web\\\\CRM-project\\\\frontend\\\\pages\\\\_app.jsx\",\n            lineNumber: 31,\n            columnNumber: 7\n        }, this)\n    }, void 0, false, {\n        fileName: \"C:\\\\Users\\\\mihai\\\\OneDrive\\\\Desktop\\\\Программирование\\\\Web\\\\CRM-project\\\\frontend\\\\pages\\\\_app.jsx\",\n        lineNumber: 30,\n        columnNumber: 5\n    }, this);\n}\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiLi9wYWdlcy9fYXBwLmpzeCIsIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7O0FBQWtDO0FBQ0g7QUFDRDtBQUVmLFNBQVNDLE9BQU8sRUFBRUMsU0FBUyxFQUFFQyxTQUFTLEVBQUU7SUFDckRILGdEQUFTQTs0QkFBQztZQUNSSTtvQ0FBWTtvQkFDVixNQUFNQyxNQUFNLE1BQU1DLE1BQU0sZ0RBQWdEO3dCQUN0RUMsUUFBUTt3QkFDUkMsU0FBUzs0QkFDUCxnQkFBZ0I7d0JBQ2xCO3dCQUNBQyxNQUFNQyxLQUFLQyxTQUFTLENBQUM7NEJBQ25CQyxjQUFjQyxhQUFhQyxPQUFPLENBQUM7d0JBQ3JDO29CQUNGO29CQUNBLElBQUlULElBQUlVLEVBQUUsRUFBRTt3QkFDVixNQUFNQyxNQUFNLE1BQU1YLElBQUlZLElBQUk7d0JBQzFCSixhQUFhSyxPQUFPLENBQUMsZUFBZUYsSUFBSUcsV0FBVzt3QkFDbkROLGFBQWFLLE9BQU8sQ0FBQyxnQkFBZ0JGLElBQUlKLFlBQVk7d0JBQ3JEUSxTQUFTQyxNQUFNLEdBQUcsQ0FBQyxjQUFjLEVBQUVMLElBQUlHLFdBQVcsRUFBRTt3QkFDcERHLFFBQVFDLEdBQUcsQ0FBQztvQkFDZCxPQUFPO3dCQUNMRCxRQUFRQyxHQUFHLENBQUM7b0JBQ2Q7Z0JBQ0Y7bUNBQUc7UUFDTDsyQkFBRyxFQUFFO0lBRUwscUJBQ0UsOERBQUNDO1FBQUlDLFdBQVc7a0JBQ2QsNEVBQUN2QjtZQUFXLEdBQUdDLFNBQVM7Ozs7Ozs7Ozs7O0FBRzlCIiwic291cmNlcyI6WyJDOlxcVXNlcnNcXG1paGFpXFxPbmVEcml2ZVxcRGVza3RvcFxc0J/RgNC+0LPRgNCw0LzQvNC40YDQvtCy0LDQvdC40LVcXFdlYlxcQ1JNLXByb2plY3RcXGZyb250ZW5kXFxwYWdlc1xcX2FwcC5qc3giXSwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHsgdXNlRWZmZWN0IH0gZnJvbSBcInJlYWN0XCI7XHJcbmltcG9ydCBcIi4uL3N0eWxlcy9nbG9iYWxzLmNzc1wiO1xyXG5pbXBvcnQgXCIuLi9zdHlsZXMvc3R5bGVzLmNzc1wiO1xyXG5cclxuZXhwb3J0IGRlZmF1bHQgZnVuY3Rpb24gTGF5b3V0KHsgQ29tcG9uZW50LCBwYWdlUHJvcHMgfSkge1xyXG4gIHVzZUVmZmVjdCgoKSA9PiB7XHJcbiAgICBzZXRJbnRlcnZhbChhc3luYyAoKSA9PiB7XHJcbiAgICAgIGNvbnN0IHJlcSA9IGF3YWl0IGZldGNoKFwiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2FwaS9hdXRoL3VwZGF0ZV90b2tlbnNcIiwge1xyXG4gICAgICAgIG1ldGhvZDogXCJQT1NUXCIsXHJcbiAgICAgICAgaGVhZGVyczoge1xyXG4gICAgICAgICAgXCJDb250ZW50LVR5cGVcIjogXCJhcHBsaWNhdGlvbi9qc29uO2NoYXJzZXQ9dXRmLThcIixcclxuICAgICAgICB9LFxyXG4gICAgICAgIGJvZHk6IEpTT04uc3RyaW5naWZ5KHtcclxuICAgICAgICAgIHJlZnJlc2hUb2tlbjogbG9jYWxTdG9yYWdlLmdldEl0ZW0oXCJyZWZyZXNoVG9rZW5cIiksXHJcbiAgICAgICAgfSksXHJcbiAgICAgIH0pO1xyXG4gICAgICBpZiAocmVxLm9rKSB7XHJcbiAgICAgICAgY29uc3QgcmVzID0gYXdhaXQgcmVxLmpzb24oKTtcclxuICAgICAgICBsb2NhbFN0b3JhZ2Uuc2V0SXRlbShcImFjY2Vzc1Rva2VuXCIsIHJlcy5hY2Nlc3NUb2tlbik7XHJcbiAgICAgICAgbG9jYWxTdG9yYWdlLnNldEl0ZW0oXCJyZWZyZXNoVG9rZW5cIiwgcmVzLnJlZnJlc2hUb2tlbik7XHJcbiAgICAgICAgZG9jdW1lbnQuY29va2llID0gYGFjY2Vzc1Rva2VuID0gJHtyZXMuYWNjZXNzVG9rZW59YDtcclxuICAgICAgICBjb25zb2xlLmxvZyhcInN1Y2Nlc3NcIik7XHJcbiAgICAgIH0gZWxzZSB7XHJcbiAgICAgICAgY29uc29sZS5sb2coXCJlcnJvclwiKTtcclxuICAgICAgfVxyXG4gICAgfSwgNjAwMDApO1xyXG4gIH0sIFtdKTtcclxuXHJcbiAgcmV0dXJuIChcclxuICAgIDxkaXYgY2xhc3NOYW1lPXtcInRleHQtc2xhdGUtOTAwIGJnLVsjRjNFOURDXSBkYXJrOmJnLWNvZmZlZSBtaW4taC1bMTAwdmhdXCJ9PlxyXG4gICAgICA8Q29tcG9uZW50IHsuLi5wYWdlUHJvcHN9IC8+XHJcbiAgICA8L2Rpdj5cclxuICApO1xyXG59XHJcbiJdLCJuYW1lcyI6WyJ1c2VFZmZlY3QiLCJMYXlvdXQiLCJDb21wb25lbnQiLCJwYWdlUHJvcHMiLCJzZXRJbnRlcnZhbCIsInJlcSIsImZldGNoIiwibWV0aG9kIiwiaGVhZGVycyIsImJvZHkiLCJKU09OIiwic3RyaW5naWZ5IiwicmVmcmVzaFRva2VuIiwibG9jYWxTdG9yYWdlIiwiZ2V0SXRlbSIsIm9rIiwicmVzIiwianNvbiIsInNldEl0ZW0iLCJhY2Nlc3NUb2tlbiIsImRvY3VtZW50IiwiY29va2llIiwiY29uc29sZSIsImxvZyIsImRpdiIsImNsYXNzTmFtZSJdLCJpZ25vcmVMaXN0IjpbXSwic291cmNlUm9vdCI6IiJ9\n//# sourceURL=webpack-internal:///./pages/_app.jsx\n");

/***/ }),

/***/ "./styles/globals.css":
/*!****************************!*\
  !*** ./styles/globals.css ***!
  \****************************/
/***/ (() => {



/***/ }),

/***/ "./styles/styles.css":
/*!***************************!*\
  !*** ./styles/styles.css ***!
  \***************************/
/***/ (() => {



/***/ }),

/***/ "react":
/*!************************!*\
  !*** external "react" ***!
  \************************/
/***/ ((module) => {

"use strict";
module.exports = require("react");

/***/ }),

/***/ "react/jsx-dev-runtime":
/*!****************************************!*\
  !*** external "react/jsx-dev-runtime" ***!
  \****************************************/
/***/ ((module) => {

"use strict";
module.exports = require("react/jsx-dev-runtime");

/***/ })

};
;

// load runtime
var __webpack_require__ = require("../webpack-runtime.js");
__webpack_require__.C(exports);
var __webpack_exec__ = (moduleId) => (__webpack_require__(__webpack_require__.s = moduleId))
var __webpack_exports__ = (__webpack_exec__("./pages/_app.jsx"));
module.exports = __webpack_exports__;

})();