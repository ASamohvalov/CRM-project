/** @type {import('tailwindcss').Config} */
module.exports = {
  darkMode: 'class',
  content: [
    "./apx/**/*.{js,ts,jsx,tsx,mdx}",
    "./pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/**/*.{js,ts,jsx,tsx,mdx}"
  ],
  theme: {
    extend: {
      colors: {
        "coffee": "#5E3023",
        "cream": "#F3E9DC"
      },
      keyframes: {
        downToEnd: {
          '0%': { 'width': '0%' },
          '100%': { 'width': '80%' },
        },
        EndtoDown: {
          '0%': { 'width': '80%' },
          '100%': { 'width': '0%' },
        }
      },
      animation: {
        downToEnd: 'downToEnd 1s ease-in-out forwards',
        EndtoDown: 'EndtoDown 1s ease-in-out',
      },
      fontFamily:{
        'Roboto': ['Roboto', 'sana']
      }
    },
  },
  plugins: [],
}

