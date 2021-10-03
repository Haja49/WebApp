for /f "tokens=5" %%a in ('netstat -aon ^| find ":9002" ^| find "LISTENING"') do taskkill /f /pid %%a
