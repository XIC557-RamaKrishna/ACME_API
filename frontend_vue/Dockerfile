FROM node:lts-alpine
WORKDIR /app
COPY package.json ./
RUN npm install
COPY public ./public
COPY src ./src
COPY babel.config.js ./
RUN  npm run build
EXPOSE 8080
CMD ["npm", "run", "serve"]
