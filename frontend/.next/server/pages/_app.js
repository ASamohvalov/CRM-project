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
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   \"default\": () => (/* binding */ Layout)\n/* harmony export */ });\n/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react/jsx-dev-runtime */ \"react/jsx-dev-runtime\");\n/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__);\n/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! react */ \"react\");\n/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_1__);\n/* harmony import */ var _styles_globals_css__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../styles/globals.css */ \"./styles/globals.css\");\n/* harmony import */ var _styles_globals_css__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(_styles_globals_css__WEBPACK_IMPORTED_MODULE_2__);\n/* harmony import */ var _styles_styles_css__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../styles/styles.css */ \"./styles/styles.css\");\n/* harmony import */ var _styles_styles_css__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/__webpack_require__.n(_styles_styles_css__WEBPACK_IMPORTED_MODULE_3__);\n\n\n\n\nfunction Layout({ Component, pageProps }) {\n    (0,react__WEBPACK_IMPORTED_MODULE_1__.useEffect)({\n        \"Layout.useEffect\": ()=>{\n            setInterval({\n                \"Layout.useEffect\": async ()=>{\n                    try {\n                        const req = await fetch(\"http://localhost:8080/api/auth/update_tokens\", {\n                            method: \"POST\",\n                            headers: {\n                                \"Content-Type\": \"application/json;charset=utf-8\"\n                            },\n                            body: JSON.stringify({\n                                refreshToken: localStorage.getItem(\"refreshToken\")\n                            })\n                        });\n                        if (req.ok) {\n                            const res = await req.json();\n                            localStorage.setItem(\"accessToken\", res.accessToken);\n                            localStorage.setItem(\"refreshToken\", res.refreshToken);\n                            document.cookie = `accessToken = ${res.accessToken}`;\n                            console.log(\"success\");\n                        } else {\n                            throw new Error();\n                        }\n                    } catch (e) {\n                        console.log(e.message);\n                    }\n                }\n            }[\"Layout.useEffect\"], 600000);\n        }\n    }[\"Layout.useEffect\"], []);\n    return /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n        className: \"text-slate-900 bg-[#F3E9DC] dark:bg-coffee min-h-[100vh]\",\n        children: /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(Component, {\n            ...pageProps\n        }, void 0, false, {\n            fileName: \"C:\\\\Users\\\\mihai\\\\OneDrive\\\\Desktop\\\\Программирование\\\\Web\\\\CRM-project\\\\frontend\\\\pages\\\\_app.jsx\",\n            lineNumber: 35,\n            columnNumber: 7\n        }, this)\n    }, void 0, false, {\n        fileName: \"C:\\\\Users\\\\mihai\\\\OneDrive\\\\Desktop\\\\Программирование\\\\Web\\\\CRM-project\\\\frontend\\\\pages\\\\_app.jsx\",\n        lineNumber: 34,\n        columnNumber: 5\n    }, this);\n}\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiLi9wYWdlcy9fYXBwLmpzeCIsIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7O0FBQWtDO0FBQ0g7QUFDRDtBQUVmLFNBQVNDLE9BQU8sRUFBRUMsU0FBUyxFQUFFQyxTQUFTLEVBQUU7SUFDckRILGdEQUFTQTs0QkFBQztZQUNSSTtvQ0FBWTtvQkFDVixJQUFHO3dCQUNELE1BQU1DLE1BQU0sTUFBTUMsTUFBTSxnREFBZ0Q7NEJBQ3hFQyxRQUFROzRCQUNSQyxTQUFTO2dDQUNQLGdCQUFnQjs0QkFDbEI7NEJBQ0FDLE1BQU1DLEtBQUtDLFNBQVMsQ0FBQztnQ0FDbkJDLGNBQWNDLGFBQWFDLE9BQU8sQ0FBQzs0QkFDckM7d0JBQ0Y7d0JBQ0EsSUFBSVQsSUFBSVUsRUFBRSxFQUFFOzRCQUNWLE1BQU1DLE1BQU0sTUFBTVgsSUFBSVksSUFBSTs0QkFDMUJKLGFBQWFLLE9BQU8sQ0FBQyxlQUFlRixJQUFJRyxXQUFXOzRCQUNuRE4sYUFBYUssT0FBTyxDQUFDLGdCQUFnQkYsSUFBSUosWUFBWTs0QkFDckRRLFNBQVNDLE1BQU0sR0FBRyxDQUFDLGNBQWMsRUFBRUwsSUFBSUcsV0FBVyxFQUFFOzRCQUNwREcsUUFBUUMsR0FBRyxDQUFDO3dCQUNkLE9BQUs7NEJBQ0gsTUFBTSxJQUFJQzt3QkFDWjtvQkFDQSxFQUFDLE9BQU1DLEdBQUU7d0JBQ1BILFFBQVFDLEdBQUcsQ0FBQ0UsRUFBRUMsT0FBTztvQkFDdkI7Z0JBQ0Y7bUNBQUc7UUFDTDsyQkFBRyxFQUFFO0lBRUwscUJBQ0UsOERBQUNDO1FBQUlDLFdBQVc7a0JBQ2QsNEVBQUMxQjtZQUFXLEdBQUdDLFNBQVM7Ozs7Ozs7Ozs7O0FBRzlCIiwic291cmNlcyI6WyJDOlxcVXNlcnNcXG1paGFpXFxPbmVEcml2ZVxcRGVza3RvcFxc0J/RgNC+0LPRgNCw0LzQvNC40YDQvtCy0LDQvdC40LVcXFdlYlxcQ1JNLXByb2plY3RcXGZyb250ZW5kXFxwYWdlc1xcX2FwcC5qc3giXSwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHsgdXNlRWZmZWN0IH0gZnJvbSBcInJlYWN0XCI7XHJcbmltcG9ydCBcIi4uL3N0eWxlcy9nbG9iYWxzLmNzc1wiO1xyXG5pbXBvcnQgXCIuLi9zdHlsZXMvc3R5bGVzLmNzc1wiO1xyXG5cclxuZXhwb3J0IGRlZmF1bHQgZnVuY3Rpb24gTGF5b3V0KHsgQ29tcG9uZW50LCBwYWdlUHJvcHMgfSkge1xyXG4gIHVzZUVmZmVjdCgoKSA9PiB7XHJcbiAgICBzZXRJbnRlcnZhbChhc3luYyAoKSA9PiB7XHJcbiAgICAgIHRyeXtcclxuICAgICAgICBjb25zdCByZXEgPSBhd2FpdCBmZXRjaChcImh0dHA6Ly9sb2NhbGhvc3Q6ODA4MC9hcGkvYXV0aC91cGRhdGVfdG9rZW5zXCIsIHtcclxuICAgICAgICBtZXRob2Q6IFwiUE9TVFwiLFxyXG4gICAgICAgIGhlYWRlcnM6IHtcclxuICAgICAgICAgIFwiQ29udGVudC1UeXBlXCI6IFwiYXBwbGljYXRpb24vanNvbjtjaGFyc2V0PXV0Zi04XCIsXHJcbiAgICAgICAgfSxcclxuICAgICAgICBib2R5OiBKU09OLnN0cmluZ2lmeSh7XHJcbiAgICAgICAgICByZWZyZXNoVG9rZW46IGxvY2FsU3RvcmFnZS5nZXRJdGVtKFwicmVmcmVzaFRva2VuXCIpLFxyXG4gICAgICAgIH0pLFxyXG4gICAgICB9KTtcclxuICAgICAgaWYgKHJlcS5vaykge1xyXG4gICAgICAgIGNvbnN0IHJlcyA9IGF3YWl0IHJlcS5qc29uKCk7XHJcbiAgICAgICAgbG9jYWxTdG9yYWdlLnNldEl0ZW0oXCJhY2Nlc3NUb2tlblwiLCByZXMuYWNjZXNzVG9rZW4pO1xyXG4gICAgICAgIGxvY2FsU3RvcmFnZS5zZXRJdGVtKFwicmVmcmVzaFRva2VuXCIsIHJlcy5yZWZyZXNoVG9rZW4pO1xyXG4gICAgICAgIGRvY3VtZW50LmNvb2tpZSA9IGBhY2Nlc3NUb2tlbiA9ICR7cmVzLmFjY2Vzc1Rva2VufWA7XHJcbiAgICAgICAgY29uc29sZS5sb2coXCJzdWNjZXNzXCIpO1xyXG4gICAgICB9ZWxzZXtcclxuICAgICAgICB0aHJvdyBuZXcgRXJyb3IoKTtcclxuICAgICAgfVxyXG4gICAgICB9Y2F0Y2goZSl7XHJcbiAgICAgICAgY29uc29sZS5sb2coZS5tZXNzYWdlKTtcclxuICAgICAgfVxyXG4gICAgfSwgNjAwMDAwKTtcclxuICB9LCBbXSk7XHJcblxyXG4gIHJldHVybiAoXHJcbiAgICA8ZGl2IGNsYXNzTmFtZT17XCJ0ZXh0LXNsYXRlLTkwMCBiZy1bI0YzRTlEQ10gZGFyazpiZy1jb2ZmZWUgbWluLWgtWzEwMHZoXVwifT5cclxuICAgICAgPENvbXBvbmVudCB7Li4ucGFnZVByb3BzfSAvPlxyXG4gICAgPC9kaXY+XHJcbiAgKTtcclxufVxyXG4iXSwibmFtZXMiOlsidXNlRWZmZWN0IiwiTGF5b3V0IiwiQ29tcG9uZW50IiwicGFnZVByb3BzIiwic2V0SW50ZXJ2YWwiLCJyZXEiLCJmZXRjaCIsIm1ldGhvZCIsImhlYWRlcnMiLCJib2R5IiwiSlNPTiIsInN0cmluZ2lmeSIsInJlZnJlc2hUb2tlbiIsImxvY2FsU3RvcmFnZSIsImdldEl0ZW0iLCJvayIsInJlcyIsImpzb24iLCJzZXRJdGVtIiwiYWNjZXNzVG9rZW4iLCJkb2N1bWVudCIsImNvb2tpZSIsImNvbnNvbGUiLCJsb2ciLCJFcnJvciIsImUiLCJtZXNzYWdlIiwiZGl2IiwiY2xhc3NOYW1lIl0sImlnbm9yZUxpc3QiOltdLCJzb3VyY2VSb290IjoiIn0=\n//# sourceURL=webpack-internal:///./pages/_app.jsx\n");

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