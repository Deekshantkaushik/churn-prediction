## Live Demo

- **Frontend Dashboard**: https://churn-prediction-3-3as5.onrender.com
- **Backend API**: https://churn-prediction-1-pueb.onrender.com/hello
- **ML Prediction Service**: https://churn-prediction-51x0.onrender.com/docs (FastAPI, interactive docs)

**Note**: Backend services are hosted on Render's free tier, which spins down after 
15 minutes of inactivity. The first request after idle time may take 30-60 seconds 
to respond while the service wakes up and frontend dashboard takes time to load graph

## Infrastructure

- **Database**: MySQL, hosted on Aiven Cloud
- **Backend hosting**: Render (Spring Boot + FastAPI, each as separate web services)
- **Frontend hosting**: React — Render

