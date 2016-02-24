package com.inventory.lab.compsci.tasks;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by peoplesoft on 2/23/2016.
 */
public class UpdateDataTask {

    public UpdateDataTask(JSONObject obj) {
       // processJson(obj);
    }

    /*try {
        JSONArray rows = object.getJSONArray("rows");

        for (int r = 0; r < rows.length(); ++r) {
            JSONObject row = rows.getJSONObject(r);
            JSONArray columns = row.getJSONArray("c");

            int position = columns.getJSONObject(0).getInt("v");
            String name = columns.getJSONObject(1).getString("v");
            int wins = columns.getJSONObject(3).getInt("v");
            int draws = columns.getJSONObject(4).getInt("v");
            int losses = columns.getJSONObject(5).getInt("v");
            int points = columns.getJSONObject(19).getInt("v");
            Team team = new Team(position, name, wins, draws, losses, points);
            teams.add(team);
        }

        final TeamsAdapter adapter = new TeamsAdapter(this, R.layout.team, teams);
        listview.setAdapter(adapter);

    } catch (JSONException e) {
        e.printStackTrace();
    }*/
}
