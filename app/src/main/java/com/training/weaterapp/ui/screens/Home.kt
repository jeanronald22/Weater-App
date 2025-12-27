package com.training.weaterapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.training.weaterapp.R
import com.training.weaterapp.components.EmptyList
import com.training.weaterapp.components.Loader
import com.training.weaterapp.components.city.CityCard
import com.training.weaterapp.ui.viewModel.HomViewModel
import com.training.weatherapp.components.Search

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
	modifier: Modifier = Modifier,
	viewModel: HomViewModel = hiltViewModel()
) {
	val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

	val citiesState = viewModel.cities.collectAsState().value
	val query = viewModel.query.collectAsState().value

	Scaffold(
		containerColor = MaterialTheme.colorScheme.background,
		modifier = modifier,
		topBar = {
			MediumTopAppBar(
				title = {
					Text(
						text = stringResource(R.string.m_t_o),
						style = MaterialTheme.typography.headlineLarge,
						fontWeight = FontWeight.SemiBold
					)
				},
				colors = TopAppBarDefaults.mediumTopAppBarColors(
					containerColor = MaterialTheme.colorScheme.background,
					scrolledContainerColor = MaterialTheme.colorScheme.background
				),
				scrollBehavior = scrollBehavior
			)
		}
	) { innerPadding ->

		LazyColumn(
			modifier = Modifier
				.padding(innerPadding)
				.padding(horizontal = 16.dp)
				.fillMaxWidth()
				.nestedScroll(scrollBehavior.nestedScrollConnection)
		) {
				stickyHeader {
					Search(
						query = query,
						onQueryChange = { viewModel.searchCity(it) },
						modifier = Modifier
							.fillMaxWidth()

					)
					Spacer(Modifier.padding(8.dp))
				}
			when {
				citiesState.isLoading -> item { Loader() }

				citiesState.data.isNullOrEmpty() -> item {

						EmptyList(
							title = stringResource(R.string.aucune_ville_trouv_e),
							subtitle = stringResource(R.string.essayez_une_autre_recherche),
							modifier = Modifier.padding(top = 20.dp)
						)

				}

				else -> items(citiesState.data!!) { city ->
					CityCard(item = city)
				}
			}
		}
	}
}


