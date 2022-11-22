import LoadingScreen from "./LoadingScreen";
import Login from "./Login";
import React from "react";

function Home({ Component, pageProps }) {
  const [loading, setLoading] = React.useState(true);
  React.useEffect(() => {
    setTimeout(() => setLoading(false), 3000);
  }, []);
  return (
    <>
      {!loading ? (
        <React.Fragment>
          <Login {...pageProps} />
        </React.Fragment>
      ) : (
        <LoadingScreen />
      )}
    </>
  );
}

export default Home
