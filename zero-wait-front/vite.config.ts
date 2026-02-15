import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    react({
      jsxImportSource: '@emotion/react', // Emotion의 JSX 프라그마를 사용하도록 설정
      babel: {
        plugins: ['@emotion/babel-plugin'], // 컴포넌트 셀렉터 인식을 위한 플러그인 추가
      },
    }),
  ],
})