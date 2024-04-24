/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {
      colors:{
        transparent: 'transparent',
        current: 'currentColor',
        'primary':'#333232',
        'secondary':'#292828',
        'purple':'#464573',
        'red':'#931F1D',
        'pink':'#F6839C',
        'white':'#F2F2F2'
      }
    },
  },
  plugins: [],
}